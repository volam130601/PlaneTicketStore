package com.planeticket.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.planeticket.dao.IPriceSeatDAO;
import com.planeticket.dto.PriceSeatDTO;
import com.planeticket.mapper.PriceSeatMapper;

@Repository
public class PriceSeatDAO extends AbstractDAO<PriceSeatDTO> implements IPriceSeatDAO {

	@Override
	public List<PriceSeatDTO> findAll() {
		String sql = "SELECT * FROM priceSeat";
		return query(sql, new PriceSeatMapper());
	}

	@Override
	public List<PriceSeatDTO> findOneById(String id) {
		String sql = "SELECT * FROM priceSeat WHERE id = ?";
		return query(sql, new PriceSeatMapper(), id);
	}
	
	@Override
	public Long insert(PriceSeatDTO priceSeatDTO) {
		String sql = "INSERT INTO PriceSeat(economy , business , firstClass) \r\n" + "values(?,?,?)";
		return insert(sql, priceSeatDTO.getEconomy(), priceSeatDTO.getBusiness(),
				priceSeatDTO.getFirstClass());
	}

	@Override
	public void update(PriceSeatDTO priceSeatDTO) {
		String sql = "UPDATE PriceSeat\r\n"
				+ "SET economy = ?,  business = ? , firstClass = ? WHERE id = ?";
		update(sql, priceSeatDTO.getEconomy(), priceSeatDTO.getBusiness(),
				priceSeatDTO.getFirstClass(), priceSeatDTO.getId());
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE PriceSeat WHERE id = ?";
		update(sql , id);
	}

}
