package com.planeticket.dao;

import com.planeticket.dto.FlightDTO;

import java.util.List;

public interface IFlightDAO extends GenericDAO<FlightDTO>{
	List<FlightDTO> findAll();
	List<FlightDTO> findOneById(String id);
	FlightDTO insertCode(FlightDTO flightDTO);
	void udpate(FlightDTO flightDTO);
	void delete(String id);
}
