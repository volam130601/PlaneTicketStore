package com.planeticket.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "AdminHomeController")
@RequestMapping(value = "/admin")
public class HomeController {
		
	@GetMapping(value = {"/" , "/home"}) 
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("admin/Home");
		return mav;
	}
	
}
