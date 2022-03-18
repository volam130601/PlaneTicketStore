package com.planeticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planeticket.dao.IPlaneDAO;
import com.planeticket.dto.AirlineDTO;
import com.planeticket.dto.PlaneDTO;
import com.planeticket.service.IAirlineService;
import com.planeticket.service.IPlaneService;

@Service
public class PlaneService implements IPlaneService{
	
	@Autowired
	private IPlaneDAO planeDAO;
	
	@Autowired
	private IAirlineService airlineService;
	
	@Override
	public List<PlaneDTO> findAll() {
		return planeDAO.findAll();
	}
	
	@Override
	public PlaneDTO findOneById(String id) {
		List<PlaneDTO> models = planeDAO.findOneById(id);
		return models.isEmpty() ? null : models.get(0);
	}

	@Override
	public void insert(PlaneDTO planeDTO) {
		AirlineDTO airlineDTO = airlineService.findOneByID(planeDTO.getIdAirline());
		planeDTO.setAirlineDTO(airlineDTO);
		List<PlaneDTO> planes = planeDAO.findAllByIdAirline(planeDTO.getIdAirline());
		int max = 0;
		for(PlaneDTO p : planes ) {
			int number = Integer.parseInt(p.getId().substring(2,5));
			if(max < number) {
				max = number;
			}
		}
		max++;
		String idPlane = "";
		if(max < 10) {
			idPlane += planeDTO.getIdAirline() + "00" + String.valueOf(max);
		}else if(max < 100) {
			idPlane += planeDTO.getIdAirline() + "0" + String.valueOf(max);
		}
		planeDTO.setId(idPlane);
		planeDAO.insert(planeDTO);
	}

	@Override
	public void update(PlaneDTO planeDTO) {
		planeDAO.update(planeDTO);
	}

	@Override
	public void delete(String id) {
		planeDAO.delete(id);
	}
	
}
