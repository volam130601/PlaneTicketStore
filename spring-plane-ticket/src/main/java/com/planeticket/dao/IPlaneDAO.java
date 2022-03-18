package com.planeticket.dao;

import com.planeticket.dto.PlaneDTO;

import java.util.List;

public interface IPlaneDAO extends GenericDAO<PlaneDTO>{
	List<PlaneDTO> findAll();
	List<PlaneDTO> findOneById(String id);
	List<PlaneDTO> findAllByIdAirline(String idAirline);
	void insert(PlaneDTO planeDTO);
	void update(PlaneDTO planeDTO);
	void delete(String id);
}
