package com.planeticket.dao;

import com.planeticket.dto.RouteDTO;

import java.util.List;

public interface IRouteDAO extends GenericDAO<RouteDTO>{
	List<RouteDTO> findAll();
	List<RouteDTO> findOneById(String id);
	List<RouteDTO> findOneByCodeFromAndCodeTo(String codeFrom, String codeTo);
	Long insert(RouteDTO routeDTO);
	void update(String status , String id);
	void delete(String id);
}
