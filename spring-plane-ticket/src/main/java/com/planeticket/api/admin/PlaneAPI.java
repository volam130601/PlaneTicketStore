package com.planeticket.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planeticket.dto.PlaneDTO;
import com.planeticket.service.IPlaneService;

@CrossOrigin
@RestController(value = "PlaneAPI")
public class PlaneAPI {
	
	@Autowired
	private IPlaneService planeService;
	
	@PostMapping("/api/plane")
	public int addPlane(@RequestBody PlaneDTO planeDTO) {
		planeService.insert(planeDTO);
		return 1;
	}
	
	@PutMapping("/api/plane")
	public int updatePlane(@RequestBody PlaneDTO planeDTO) {
		planeService.update(planeDTO);
		return 1;
	}
	
	@DeleteMapping("/api/plane/{id}")
	public String deletePlane(@PathVariable("id") String id) {
		planeService.delete(id);
		return id;
	}
	
}
