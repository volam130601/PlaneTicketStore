package com.planeticket.controller.admin;

import com.planeticket.constant.SystemConstant;
import com.planeticket.service.IAirportService;
import com.planeticket.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin", name = "AdminRoute")
public class RouteController {

	@Autowired
	private IRouteService routeService;

	@Autowired
	private IAirportService airportService;

	@GetMapping("/manager/route")
	public ModelAndView getAll() {
		ModelAndView mav = new ModelAndView("admin/Route");
		mav.addObject(SystemConstant.ROUTE, routeService.findAll());
		mav.addObject(SystemConstant.AIRPORT, airportService.findAll());
		return mav;
	}
}
