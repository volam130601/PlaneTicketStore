package com.planeticket.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planeticket.dto.FlightDTO;
import com.planeticket.dto.PlaneDTO;
import com.planeticket.dto.RouteDTO;
import com.planeticket.service.IFlightService;
import com.planeticket.service.IPlaneService;
import com.planeticket.service.IRouteService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController(value = "FlightAPI")
public class FlightAPI {

	@Autowired
	private IFlightService flightService;
	
	@Autowired
	private IRouteService routeService;

	@Autowired
	private IPlaneService planeService;

	@GetMapping("/api/flight")
	public List<FlightDTO> getAllFlight() {
		List<FlightDTO> flights = flightService.findAll();
		for (FlightDTO f : flights) {
			RouteDTO route = routeService.findOneByID(f.getIdRoute().toString());
			PlaneDTO plane = planeService.findOneById(f.getIdPlane());
			f.setRouteDTO(route);
			f.setPlaneDTO(plane);
		}
		return flightService.findAll();
	}

	@PostMapping("/api/flight")
	public FlightDTO addFlight(@RequestBody FlightDTO flightDTO) {
		return flightService.insertCode(flightDTO);
	}

	@PutMapping("/api/flight")
	public FlightDTO updateFlight(@RequestBody FlightDTO flightDTO) {
		System.out.println(flightDTO);
		return flightService.udpate(flightDTO);
	}

//	@CrossOrigin(origins = "http://localhost:8080")
	@DeleteMapping("/api/flight/{id}")
	public String deleteFlight(@PathVariable("id") String id) {
		flightService.delete(id);
		return id;
	}

}
