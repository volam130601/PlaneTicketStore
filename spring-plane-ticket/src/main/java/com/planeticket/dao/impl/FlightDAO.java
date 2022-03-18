package com.planeticket.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.planeticket.dao.IFlightDAO;
import com.planeticket.dto.FlightDTO;
import com.planeticket.mapper.FlightMapper;

@Repository
public class FlightDAO extends AbstractDAO<FlightDTO> implements IFlightDAO {

	@Override
	public List<FlightDTO> findAll() {
		String sql = "SELECT * FROM Flight ORDER By idRoute";
		return query(sql, new FlightMapper());
	}

	@Override
	public List<FlightDTO> findOneById(String id) {
		String sql = "SELECT * FROM Flight WHERE id = ?";
		return query(sql, new FlightMapper(), id);
	}

	@Override
	public FlightDTO insertCode(FlightDTO flightDTO) {
		String sql = "insert into Flight(id, idRoute , idPlane , dateStart, dateEnd, idPriceSeat)\r\n" + "values(?,?,?,?,?,?)";
		boolean check = insertCode(sql, flightDTO.getId(), flightDTO.getIdRoute(), flightDTO.getIdPlane(), flightDTO.getDateStart() ,
				flightDTO.getDateEnd() , flightDTO.getIdPriceSeat());
		if(check == true) {
			return flightDTO;
		}
		return null;
	}
	
	@Override
	public void udpate(FlightDTO flightDTO) {
		String sql = "update Flight\r\n" + "set idRoute= ? , idPlane=? , dateStart=? , dateEnd=?\r\n"
				+ "where id =?";
		update(sql, flightDTO.getIdRoute(), flightDTO.getIdPlane(), flightDTO.getDateStart(), flightDTO.getDateEnd(), flightDTO.getId());
	}

	@Override
	public void delete(String id) {
		String sql= "delete Flight where id = ?";
		update(sql, id);
	}

}
