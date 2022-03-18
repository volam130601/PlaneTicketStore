package com.planeticket.service;

import com.planeticket.dto.RouteDTO;

import java.util.List;

public interface IRouteService {
	List<RouteDTO> findAll();
	RouteDTO findOneByID(String id);
	RouteDTO findOneByCodeFromAndCodeTo(String codeFrom , String codeTo);
	Long insert(RouteDTO routeDTO);
	void update(String status , String id);
	void delete(String id);
}
