package com.planeticket.mapper;

import com.planeticket.dto.AirportDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportMapper implements RowMapper<AirportDTO>{
	@Override
	public AirportDTO mapRow(ResultSet rs) {
		AirportDTO dto;
		try {
			dto = new AirportDTO();
			dto.setId(Integer.parseInt(rs.getString("id")));
			dto.setCode(rs.getString("code"));
			dto.setName(rs.getString("name"));
			dto.setCountry(rs.getString("country"));
			return dto;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
}
