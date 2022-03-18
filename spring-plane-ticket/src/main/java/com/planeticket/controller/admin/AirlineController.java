package com.planeticket.controller.admin;

import com.planeticket.constant.SystemConstant;
import com.planeticket.dto.AirlineDTO;
import com.planeticket.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller()
@RequestMapping(value = "/admin", name = "AdminOfManagerAirline")
public class AirlineController {
	
	@Autowired
	private IAirlineService airlineService;
	
	@GetMapping(value = "/manager/airline")
	public ModelAndView getAllAirline(@ModelAttribute("airline") AirlineDTO arAirlineDTO) {
		ModelAndView mav = new ModelAndView("admin/Airline");
		mav.addObject(SystemConstant.AIRLINE, airlineService.findAll());
		return mav;
	}

	@PostMapping(value = "/manager/airline/add")
	public ModelAndView addAirline(@ModelAttribute("airline") AirlineDTO airlineDTO, @RequestParam("message") String message) {
		ModelAndView mav = new ModelAndView("admin/Airline");
		airlineDTO.setStatus("true");
		if(airlineDTO.getId() != null) {
			airlineService.insert(airlineDTO);
			if(message != null) {
				mav.addObject("message" , "add_success");
			}
		} else { 
			if(message == null) {
				mav.addObject("message" , "add_error");
			}
		}
		mav.addObject(SystemConstant.AIRLINE , airlineService.findAll());
		return mav;
	}
	
	@PostMapping(value = "/manager/airline/edit")
	public ModelAndView updateAirline(@ModelAttribute("airline") AirlineDTO airlineDTO , @RequestParam("message") String message) {
		ModelAndView mav = new ModelAndView("admin/Airline");
		airlineService.update(airlineDTO);
		if(message != null) {
			mav.addObject("message" , "update_success");
		}
		mav.addObject(SystemConstant.AIRLINE , airlineService.findAll());
		return mav;
	}
	
//	@PostMapping(value = "/manager/airline")
//	public ModelAndView updateStatusAirline(@RequestParam("status") String status , @RequestParam("id") String id) {
//		ModelAndView mav = new ModelAndView("admin/Airline");
//		airlineService.updateStatus(status, id);
//		mav.addObject(SystemConstant.AIRLINE , airlineService.findAll());
//		return mav;
//	}
	
	@GetMapping(value = "/manager/airline/delete/{id}")
	public void updateStatusAirline(@PathVariable("id") String id,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		airlineService.delete(id);
		response.sendRedirect(request.getContextPath()+"/admin/manager/airline");
	}
	
	
}
