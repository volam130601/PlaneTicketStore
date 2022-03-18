package com.planeticket.mapper;

import com.planeticket.dto.AirlineDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AirlineMapper implements RowMapper<AirlineDTO>{
	@Override
	public AirlineDTO mapRow(ResultSet rs) {
		try {
			AirlineDTO dto = new AirlineDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setDescription(rs.getString("description"));
			dto.setLogo(rs.getString("logo"));
			dto.setStatus(rs.getString("status"));
			return dto;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
