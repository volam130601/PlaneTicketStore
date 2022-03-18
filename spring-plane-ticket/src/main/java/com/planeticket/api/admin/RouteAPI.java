package com.planeticket.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planeticket.dto.RouteDTO;
import com.planeticket.service.IRouteService;

@CrossOrigin
@RestController(value = "RouteAPI")
@RequestMapping("/api/route")
public class RouteAPI {
	
	@Autowired
	private IRouteService routeService;
	
	@GetMapping("/{id}")
	public RouteDTO getOneRoute(@PathVariable("id") String id) {
		return routeService.findOneByID(id);
	}
	
	@PostMapping("")
	public RouteDTO addRoute(@RequestBody RouteDTO routeDTO) {
		//Delay
		return routeDTO;
	}
	
	@PutMapping("")
	public RouteDTO updateRoute(@RequestBody RouteDTO routeDTO) {
		//Delay
		return routeDTO;
	}
	
	
	
}
