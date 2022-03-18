package com.planeticket.service.impl;

import com.planeticket.dao.IAirportDAO;
import com.planeticket.dto.AirportDTO;
import com.planeticket.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService implements IAirportService{
	
	@Autowired
	private IAirportDAO airpotDAO;

	@Override
	public List<AirportDTO> findAll() {
		return airpotDAO.findAll();
	}

	@Override
	public AirportDTO findOneByCode(String code) {
		List<AirportDTO> models = airpotDAO.findAll();
		return models.isEmpty() ? null : models.get(0);
	}
	
	
}
