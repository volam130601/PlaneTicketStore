package com.planeticket.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.planeticket.constant.SystemConstant;
import com.planeticket.dto.AirlineDTO;
import com.planeticket.dto.PlaneDTO;
import com.planeticket.service.IAirlineService;
import com.planeticket.service.IPlaneService;

@Controller
@RequestMapping(value = "/admin", name = "ManagerPlane")
public class PlaneController {
	
	@Autowired
	private IPlaneService planeService;
	
	@Autowired
	private IAirlineService airlineService;
	
	@GetMapping("/plane/list")
	public ModelAndView listPlane(@RequestParam(value = "message", required = false) String message ) {
		ModelAndView mav = new ModelAndView("admin/plane/List");
		if(message != null) {
			mav.addObject("message" , "delete-success");
		}
		mav.addObject(SystemConstant.PLANE , planeService.findAll());
		return mav;
	}
	
	@GetMapping("/plane/edit")
	public ModelAndView editPlane(@RequestParam(value = "id" , required = false) String id ) {
		ModelAndView mav = new ModelAndView("admin/plane/Edit");
		PlaneDTO planeDTO = new PlaneDTO();
		if(id != null) {
			planeDTO = planeService.findOneById(id);
			AirlineDTO airlineDTO = airlineService.findOneByID(planeDTO.getIdAirline());
			planeDTO.setAirlineDTO(airlineDTO);
		}
		mav.addObject(SystemConstant.AIRLINE , airlineService.findAll());
		mav.addObject(SystemConstant.MODEL, planeDTO);
		return mav;
		
	}
}
