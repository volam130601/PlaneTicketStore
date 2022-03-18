package com.planeticket.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.planeticket.dto.AirlineDTO;
import com.planeticket.service.IAirlineService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController(value = "airlineAPI")
public class AirlineAPI {
	
	@Autowired
	private IAirlineService airlineService;
	
	@GetMapping("/api/airline")
	public List<AirlineDTO> getAll() {
		return airlineService.findAll();
	}
	
	@PostMapping("/api/airline")
	public AirlineDTO getOneByID(@RequestParam("id") String id) {
		return airlineService.findOneByID(id);
	}
	
	@PutMapping(value = "/api/airline/status")
	public int updateStatus(@RequestBody List<AirlineDTO> airlineDTOs) {
		for(AirlineDTO a : airlineDTOs) {
			airlineService.updateStatus(a.getStatus(), a.getId());
		}
		return 1;
	}
}
