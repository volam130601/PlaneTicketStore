package com.planeticket.service;

import java.util.List;

import com.planeticket.dto.PriceSeatDTO;

public interface IPriceSeatService {
	List<PriceSeatDTO> findAll();
	PriceSeatDTO findOneById(String id);
	Long insert(PriceSeatDTO priceSeatDTO);
	void update(PriceSeatDTO priceSeatDTO);
	void delete(String id);
}
