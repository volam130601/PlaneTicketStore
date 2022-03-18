package com.planeticket.service;

import com.planeticket.dto.AirlineDTO;

import java.util.List;

public interface IAirlineService {
	List<AirlineDTO> findAll();
	AirlineDTO findOneByID(String id);
	Long insert(AirlineDTO airlineDTO);
	void update(AirlineDTO airlineDTO);
	void updateStatus(String status , String id);
	void delete(String id);
}
