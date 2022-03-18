package com.planeticket.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.planeticket.dto.PriceSeatDTO;

public class PriceSeatMapper implements RowMapper<PriceSeatDTO>{

	@Override
	public PriceSeatDTO mapRow(ResultSet rs) {
		PriceSeatDTO dto = new PriceSeatDTO();
		try {
			dto.setId(rs.getInt("id"));
			dto.setEconomy(rs.getInt("economy"));
			dto.setBusiness(rs.getInt("business"));
			dto.setFirstClass(rs.getInt("firstClass"));
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
