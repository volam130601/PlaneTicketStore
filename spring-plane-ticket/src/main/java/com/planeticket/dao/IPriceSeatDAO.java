package com.planeticket.dao;

import java.util.List;

import com.planeticket.dto.PriceSeatDTO;

public interface IPriceSeatDAO extends GenericDAO<PriceSeatDTO>{
	List<PriceSeatDTO> findAll();
	List<PriceSeatDTO> findOneById(String id);
	Long insert(PriceSeatDTO priceSeatDTO);
	void update(PriceSeatDTO priceSeatDTO);
	void delete(String id);
}
