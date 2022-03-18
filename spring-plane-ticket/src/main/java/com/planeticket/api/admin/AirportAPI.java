package com.planeticket.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planeticket.dto.AirportDTO;
import com.planeticket.service.IAirportService;

//@CrossOrigin(value = "http://localhost:5500", maxAge = 3600)
@CrossOrigin
@RestController(value = "AirportApi")
public class AirportAPI {
	
	@Autowired
	private IAirportService airportService;

	@GetMapping("/api/airport")
	public List<AirportDTO> getAll() {
		return airportService.findAll();
	}
}
