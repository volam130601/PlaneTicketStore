package com.planeticket.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.planeticket.constant.SystemConstant;
import com.planeticket.dto.FlightDTO;
import com.planeticket.dto.PlaneDTO;
import com.planeticket.dto.PriceSeatDTO;
import com.planeticket.dto.RouteDTO;
import com.planeticket.service.IAirportService;
import com.planeticket.service.IFlightService;
import com.planeticket.service.IPlaneService;
import com.planeticket.service.IPriceSeatService;
import com.planeticket.service.IRouteService;

@Controller()
@RequestMapping(value = "/admin", name = "AdminOfManagerFlight")
public class FlightController {

	@Autowired
	private IFlightService flightService;

	@Autowired
	private IRouteService routeService;

	@Autowired
	private IPlaneService planeService;

	@Autowired
	private IAirportService airportService;
	
	@Autowired
	private IPriceSeatService priceSeatService;

	@GetMapping("/flight/list")
	public String getFlightList(Model model, HttpServletRequest request, 
			@RequestParam(value = "message" , required = false) String message) {
		List<FlightDTO> flights = new ArrayList<FlightDTO>();
		flights = flightService.findAll();
		for (FlightDTO f : flights) {
			RouteDTO route = routeService.findOneByID(f.getIdRoute().toString());
			PlaneDTO plane = planeService.findOneById(f.getIdPlane());
			f.setRouteDTO(route);
			f.setPlaneDTO(plane);
		}
		if(message != null) {
			model.addAttribute("message" , "delete_success");
		}
		model.addAttribute(SystemConstant.FLIGHT, flights);
		return "admin/flight/List";
	}

	@GetMapping("/flight/edit")
	public ModelAndView editFlight(@RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/flight/Edit");
		FlightDTO flightDTO = new FlightDTO();
		
		if (id != null) {
			flightDTO = flightService.findOneById(id);
			flightDTO.setRouteDTO(routeService.findOneByID(flightDTO.getIdRoute().toString()));
			flightDTO.setPlaneDTO(planeService.findOneById(flightDTO.getIdPlane().toString()));
			System.out.println(flightDTO.getIdPriceSeat());
			PriceSeatDTO priceSeatDTO = priceSeatService.findOneById(flightDTO.getIdPriceSeat().toString());
			flightDTO.setEconomy(priceSeatDTO.getEconomy());
			flightDTO.setBusiness(priceSeatDTO.getBusiness());
			flightDTO.setFirstClass(priceSeatDTO.getFirstClass());
		}
		mav.addObject(SystemConstant.AIRPORT, airportService.findAll());
		mav.addObject(SystemConstant.PLANE, planeService.findAll());
		mav.addObject(SystemConstant.MODEL, flightDTO);
		return mav;

	}
}
