package com.planeticket.dao;

import com.planeticket.dto.AirportDTO;

import java.util.List;

public interface IAirportDAO extends GenericDAO<AirportDTO>{
	List<AirportDTO> findAll();
	List<AirportDTO> findOneByCode(String code);
}
