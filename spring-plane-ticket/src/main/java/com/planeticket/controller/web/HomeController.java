package com.planeticket.controller.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.planeticket.constant.SystemConstant;
import com.planeticket.dto.FlightDTO;
import com.planeticket.dto.PlaneDTO;
import com.planeticket.dto.RouteDTO;
import com.planeticket.dto.sub.SearchFlightDTO;
import com.planeticket.service.IAirlineService;
import com.planeticket.service.IAirportService;
import com.planeticket.service.IFlightService;
import com.planeticket.service.IPlaneService;
import com.planeticket.service.IRouteService;

@CrossOrigin
@Controller(value = "WebHomeController")
@RequestMapping(value = "/web")
public class HomeController {

	@Autowired
	private IAirportService airportService;

	@Autowired
	private IFlightService flightService;

	@Autowired
	private IRouteService routeService;
	
	@Autowired
	private IAirlineService airlineService;
	
	@Autowired
	private IPlaneService planeService;

	@GetMapping(value = { "/home" })
	public ModelAndView webHome() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject(SystemConstant.AIRPORT, airportService.findAll());
		SearchFlightDTO searchs = new SearchFlightDTO();
		mav.addObject(SystemConstant.MODEL, searchs);
		return mav;
	}
	
	//Page Choose Flight
	@GetMapping("/find-flight")
	public ModelAndView getSearchFlight(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("web/FindFlight");

		//Get Cookie
		SearchFlightDTO searchList = new SearchFlightDTO();
		Cookie[] cookies = request.getCookies();
		Cookie cookie;
		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];
			if (cookie.getName().equals("codeFrom")) {
				searchList.setCodeFrom(cookie.getValue());
			} else if (cookie.getName().equals("codeTo")) {
				searchList.setCodeTo(cookie.getValue());
			} else if (cookie.getName().equals("dateLeave")) {
				String date = new SimpleDateFormat("yyyy-MM-dd hh:mm a").format(new Date(Long.parseLong(cookie.getValue())));
				searchList.setDateLeave(date);
//				System.out.println(date);
			} else if (cookie.getName().equals("typePassenger")) {
				searchList.setTypePassenger(cookie.getValue());
			} else if (cookie.getName().equals("typeSeat")) {
				searchList.setTypeSeat(cookie.getValue());
			}
		}
//		System.out.println(searchList);
		if (searchList != null) {
			List<FlightDTO> flights = flightService.findAll();
			RouteDTO route = routeService.findOneByCodeFromAndCodeTo(searchList.getCodeFrom(), searchList.getCodeTo());
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd hh:mm a").parse(searchList.getDateLeave());
				searchList.setDateLeave(new SimpleDateFormat("E, yyyy-MM-dd hh:mm a").format(date));
				List<FlightDTO> newLF = new ArrayList<FlightDTO>();
				for (FlightDTO f : flights) {
					Date d1 = new SimpleDateFormat("yyyy-MM-dd hh:mm a").parse(f.getDateStart());
					if (f.getIdRoute() == route.getId() && d1.compareTo(date) > 0){
						f.setRouteDTO(routeService.findOneByID(String.valueOf(f.getIdRoute())));
						f.setPlaneDTO(planeService.findOneById(f.getIdPlane()));
						f.getPlaneDTO().setAirlineDTO(airlineService.findOneByID(f.getPlaneDTO().getIdAirline())); 
						SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd hh:mm");
						f.setDateStart(df.format(df.parse(f.getDateStart())));
						f.setDateEnd(df.format(df.parse(f.getDateEnd())));
						newLF.add(f);
					}
				}
				mav.addObject(SystemConstant.FLIGHT, newLF);
//				System.out.println(newLF);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			mav.addObject(SystemConstant.AIRPORT, airportService.findAll());
			mav.addObject(SystemConstant.MODEL, searchList);
		}
		return mav;
	}
	
	//Set Cookie
	@PostMapping("/setCookie")
	public void setCookie(RedirectAttributes attributes, @RequestBody SearchFlightDTO searchFlightDTO,
			HttpServletResponse response) throws ParseException {
		Cookie codeFrom = new Cookie("codeFrom", searchFlightDTO.getCodeFrom());
		Cookie codeTo = new Cookie("codeTo", searchFlightDTO.getCodeTo());

		Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm a").parse(searchFlightDTO.getDateLeave());
		Cookie dateLeave = new Cookie("dateLeave", String.valueOf(date.getTime()));
//		if(!searchFlightDTO.getDateComeBack().equals("")) {
//			Date date2 = new SimpleDateFormat("yyyy-MM-dd hh:mm a").parse(searchFlightDTO.getDateComeBack());
//			Cookie dateComeBack = new Cookie("dateComeBack", String.valueOf(date2.getTime()));
//			dateComeBack.setMaxAge(60 * 60 * 24);
//			response.addCookie(dateComeBack);
//		}
		Cookie typePassenger = new Cookie("typePassenger", searchFlightDTO.getTypePassenger());
		Cookie typeSeat = new Cookie("typeSeat", searchFlightDTO.getTypeSeat());

		codeFrom.setMaxAge(60 * 60 * 24);
		codeTo.setMaxAge(60 * 60 * 24);
		dateLeave.setMaxAge(60 * 60 * 24);
		typePassenger.setMaxAge(60 * 60 * 24);
		typeSeat.setMaxAge(60 * 60 * 24);

		response.addCookie(codeFrom);
		response.addCookie(codeTo);
		response.addCookie(dateLeave);
		response.addCookie(typePassenger);
		response.addCookie(typeSeat);
//		return new RedirectView("find-flight");
	}

}
