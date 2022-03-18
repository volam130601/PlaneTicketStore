package com.planeticket.service.impl;

import com.planeticket.dao.IRouteDAO;
import com.planeticket.dto.RouteDTO;
import com.planeticket.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService implements IRouteService{

	@Autowired
	private IRouteDAO routeDAO;
	
	@Override
	public List<RouteDTO> findAll() {
		return routeDAO.findAll();
	}

	@Override
	public RouteDTO findOneByID(String id) {
		List<RouteDTO> models = routeDAO.findOneById(id);
		return models.isEmpty() ? null : models.get(0);
	}
	
	@Override
	public RouteDTO findOneByCodeFromAndCodeTo(String codeFrom, String codeTo) {
		List<RouteDTO> models = routeDAO.findOneByCodeFromAndCodeTo(codeFrom, codeTo);
		return models.isEmpty() ? null : models.get(0);
	}

	@Override
	public Long insert(RouteDTO routeDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(String status, String id) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
