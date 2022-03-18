package com.planeticket.dao.impl;

import com.planeticket.dao.IRouteDAO;
import com.planeticket.dto.RouteDTO;
import com.planeticket.mapper.RouteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteDAO extends AbstractDAO<RouteDTO> implements IRouteDAO {

	@Override
	public List<RouteDTO> findAll() {
		String sql = "SELECT * FROM route";
		return query(sql, new RouteMapper());
	}

	@Override
	public List<RouteDTO> findOneById(String id) {
		String sql = "SELECT * FROM route WHERE id = ?";
		return query(sql, new RouteMapper() , id);
	}
	
	@Override
	public List<RouteDTO> findOneByCodeFromAndCodeTo(String codeFrom, String codeTo) {
		String sql = "SELECT * FROM route WHERE codeFrom = ? and codeTo = ?";
		return query(sql, new RouteMapper() , codeFrom , codeTo);
	}
	
	@Override
	public Long insert(RouteDTO routeDTO) {
		String sql = "INSERT INTO Route(codeFrom , codeTo) values(?,?)";
		return insert(sql, new RouteMapper());
	}

	@Override
	public void update(String status, String id) {
		String sql = "UPDATE Route Set status = ? WHERE id = ?";
		update(sql, status , id);
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE Route Where id =?";
		update(sql, id);
	}
}
