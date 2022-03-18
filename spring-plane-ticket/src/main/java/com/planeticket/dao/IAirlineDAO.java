package com.planeticket.dao;

import com.planeticket.dto.AirlineDTO;

import java.util.List;

public interface IAirlineDAO extends GenericDAO<AirlineDTO>{
	List<AirlineDTO> findAll();
	List<AirlineDTO> findOneByID(String id);
	Long insert(AirlineDTO airlineDTO);
	void update(AirlineDTO airlineDTO);
	void updateStatus(String status , String id);
	void delete(String id);
}
