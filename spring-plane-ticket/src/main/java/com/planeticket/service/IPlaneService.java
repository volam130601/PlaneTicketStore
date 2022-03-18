package com.planeticket.service;

import com.planeticket.dto.PlaneDTO;

import java.util.List;

public interface IPlaneService {
	List<PlaneDTO> findAll();
	PlaneDTO findOneById(String id);
	void insert(PlaneDTO planeDTO);
	void update(PlaneDTO planeDTO);
	void delete(String id);
}
