package com.planeticket.dao.impl;

import com.planeticket.dao.IAirportDAO;
import com.planeticket.dto.AirportDTO;
import com.planeticket.mapper.AirportMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportDAO extends AbstractDAO<AirportDTO> implements IAirportDAO{

	@Override
	public List<AirportDTO> findAll() {
		String sql = "SELECT * FROM Airport";
		return query(sql, new AirportMapper());
	}
	
	@Override
	public List<AirportDTO> findOneByCode(String code) {
		String sql = "SELECT * FROM Airport WHERE code = ?";
		return query(sql, new AirportMapper(), code);
	}
}
