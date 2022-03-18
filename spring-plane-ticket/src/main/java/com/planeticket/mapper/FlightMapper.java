package com.planeticket.mapper;

import com.planeticket.dto.FlightDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightMapper implements RowMapper<FlightDTO> {

	@Override
	public FlightDTO mapRow(ResultSet rs) {
		try {
			FlightDTO dto = new FlightDTO();
			dto.setId(rs.getString("id"));
			dto.setIdRoute(rs.getInt("idRoute"));
			dto.setIdPlane(rs.getString("idPlane"));
			dto.setDateStart(rs.getString("dateStart"));
			dto.setDateEnd(rs.getString("dateEnd"));
			dto.setIdPriceSeat(rs.getInt("idPriceSeat"));
			return dto;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
