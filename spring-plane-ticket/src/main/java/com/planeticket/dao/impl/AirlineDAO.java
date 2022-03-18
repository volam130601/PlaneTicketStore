package com.planeticket.dao.impl;

import com.planeticket.dao.IAirlineDAO;
import com.planeticket.dto.AirlineDTO;
import com.planeticket.mapper.AirlineMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirlineDAO extends AbstractDAO<AirlineDTO> implements IAirlineDAO {
	@Override
	public List<AirlineDTO> findAll() {
		String sql = "SELECT * FROM Airline";
		return query(sql, new AirlineMapper());
	}
	
	@Override
	public List<AirlineDTO> findOneByID(String id) {
		String sql = "SELECT * FROM Airline WHERE id = ?";
		return query(sql, new AirlineMapper(), id);
	}
	
	@Override
	public Long insert(AirlineDTO airlineDTO) {
		String sql = "INSERT INTO Airline(id, name, description , logo , status) \r\n" + " VALUES(?,?,?,?,?)";
		return insert(sql, airlineDTO.getId(), airlineDTO.getName(), airlineDTO.getDescription(), airlineDTO.getLogo(),
				airlineDTO.getStatus());
	}

	@Override
	public void update(AirlineDTO airlineDTO) {
		String sql = "UPDATE Airline\r\n" + "SET name = ? , description = ? , logo = ?\r\n" + "WHERE id = ?";
		update(sql, airlineDTO.getName(), airlineDTO.getDescription(), airlineDTO.getLogo(), airlineDTO.getId());
	}
	
	@Override
	public void updateStatus(String status, String id) {
		String sql = "UPDATE Airline SET status = ? WHERE id = ?";
		update(sql, status , id);
	}
	
	@Override
	public void delete(String id) {
		String sql ="DELETE Airline WHERE id = ?";
		update(sql, id);
	}
}
