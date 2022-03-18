package com.planeticket.dao.impl;

import com.planeticket.dao.IPlaneDAO;
import com.planeticket.dto.PlaneDTO;
import com.planeticket.mapper.PlaneMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaneDAO extends AbstractDAO<PlaneDTO> implements IPlaneDAO {

	@Override
	public List<PlaneDTO> findAll() {
		String sql = "SELECT * FROM plane";
		return query(sql, new PlaneMapper());
	}

	@Override
	public List<PlaneDTO> findOneById(String id) {
		String sql = "SELECT * FROM plane WHERE id = ?";
		return query(sql, new PlaneMapper(), id);
	}
	
	@Override
	public List<PlaneDTO> findAllByIdAirline(String idAirline) {
		String sql = "select * from plane where idAirline = ?";
		return query(sql, new PlaneMapper(), idAirline);
	}

	@Override
	public void insert(PlaneDTO planeDTO) {
		String sql = "INSERT INTO Plane(id , idAirline , status , totalSeat , factory) values(?,?,?,?,?)";
		insert(sql, planeDTO.getId(), planeDTO.getIdAirline(), planeDTO.getStatus(), planeDTO.getTotalSeat(),
				planeDTO.getFactory());
	}

	@Override
	public void update(PlaneDTO planeDTO) {
		String sql ="UPDATE Plane set idAirline = ? , status  = ?, totalSeat = ? , factory = ? WHERE id  = ?";
		update(sql, planeDTO.getIdAirline(), planeDTO.getStatus(), planeDTO.getTotalSeat(),
				planeDTO.getFactory(), planeDTO.getId());
	}	

	@Override
	public void delete(String id) {
		String sql = "DELETE Plane WHERE id = ?";
		update(sql , id);
	}

}
