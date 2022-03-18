package com.planeticket.mapper;

import com.planeticket.dto.RouteDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteMapper implements RowMapper<RouteDTO>{
	@Override
	public RouteDTO mapRow(ResultSet rs) {
		RouteDTO dto = new RouteDTO();
		try {
			dto.setId(Integer.parseInt(rs.getString("id")));
			dto.setCodeFrom(rs.getString("codeFrom"));
			dto.setCodeTo(rs.getString("codeTo"));
			dto.setStatus(rs.getString("status"));
			return dto;
		} catch (NumberFormatException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
