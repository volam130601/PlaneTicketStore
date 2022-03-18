package com.planeticket.service;

import com.planeticket.dto.FlightDTO;

import java.util.List;

public interface IFlightService {
	List<FlightDTO> findAll();
	FlightDTO findOneById(String id);
	FlightDTO insertCode(FlightDTO flightDTO);
	FlightDTO udpate(FlightDTO flightDTO);
	void delete(String id);
}
