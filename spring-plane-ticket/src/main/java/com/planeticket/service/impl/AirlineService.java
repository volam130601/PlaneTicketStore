package com.planeticket.service.impl;

import com.planeticket.dao.IAirlineDAO;
import com.planeticket.dto.AirlineDTO;
import com.planeticket.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService implements IAirlineService{
	
	@Autowired
	private IAirlineDAO airlineDAO;
	
	@Override
	public List<AirlineDTO> findAll() {
		return airlineDAO.findAll();
	}

	@Override
	public AirlineDTO findOneByID(String id) {
		List<AirlineDTO> models = airlineDAO.findOneByID(id);
		return models.isEmpty() ? null : models.get(0);
	}

	@Override
	public Long insert(AirlineDTO airlineDTO) {
		return airlineDAO.insert(airlineDTO);
	}

	@Override
	public void update(AirlineDTO airlineDTO) {
		airlineDAO.update(airlineDTO);
	}

	@Override
	public void updateStatus(String status, String id) {
		airlineDAO.updateStatus(status, id);
	}

	@Override
	public void delete(String id) {
		airlineDAO.delete(id);
	}
}
