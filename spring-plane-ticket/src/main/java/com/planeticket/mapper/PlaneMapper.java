package com.planeticket.mapper;

import com.planeticket.dto.PlaneDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneMapper implements RowMapper<PlaneDTO>{
	@Override
	public PlaneDTO mapRow(ResultSet rs) {
		PlaneDTO dto;
		try {
			dto = new PlaneDTO();
					dto.setId(rs.getString("id"));
					dto.setIdAirline(rs.getString("idAirline"));
					dto.setStatus(rs.getString("status"));
					dto.setTotalSeat(rs.getInt("totalSeat"));
					dto.setFactory(rs.getString("factory"));
			return dto;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
}
