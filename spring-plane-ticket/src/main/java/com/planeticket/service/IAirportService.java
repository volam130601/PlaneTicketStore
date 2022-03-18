package com.planeticket.service;

import com.planeticket.dto.AirportDTO;

import java.util.List;

public interface IAirportService {
	List<AirportDTO> findAll();
	AirportDTO findOneByCode(String code);
}
