package com.planeticket.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.planeticket.constant.SystemConstant;
import com.planeticket.service.IAirportService;

@Controller(value = "AirportController")
@RequestMapping("/admin")
public class AirportController {
	
	@Autowired
	private IAirportService airportService;
	
	@GetMapping("/airport")
	public ModelAndView showAirpot() {
		ModelAndView  mav= new ModelAndView("admin/airport/Airport");
		mav.addObject(SystemConstant.AIRPORT,airportService.findAll());
		return mav;
	}
}
