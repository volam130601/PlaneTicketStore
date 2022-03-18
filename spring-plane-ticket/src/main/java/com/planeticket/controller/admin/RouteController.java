package com.planeticket.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.planeticket.constant.SystemConstant;
import com.planeticket.dto.RouteDTO;
import com.planeticket.service.IAirportService;
import com.planeticket.service.IRouteService;

@Controller
@RequestMapping(value = "/admin", name = "AdminRoute")
public class RouteController {

	@Autowired
	private IRouteService routeService;

	@Autowired
	private IAirportService airportService;

	@GetMapping("/route")
	public ModelAndView getAll(@ModelAttribute("route") RouteDTO routeDTO) {
		ModelAndView mav = new ModelAndView("admin/route/Route");
		mav.addObject(SystemConstant.ROUTE, routeService.findAll());
		mav.addObject(SystemConstant.AIRPORT, airportService.findAll());
		return mav;
	}
}
