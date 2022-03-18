package com.planeticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planeticket.dao.IPriceSeatDAO;
import com.planeticket.dto.PriceSeatDTO;
import com.planeticket.service.IPriceSeatService;

@Service
public class PriceSeatService implements IPriceSeatService{

	@Autowired
	private IPriceSeatDAO priceSeatDAO;
	
	@Override
	public List<PriceSeatDTO> findAll() {
		return priceSeatDAO.findAll();
	}

	@Override
	public PriceSeatDTO findOneById(String id) {
		List<PriceSeatDTO> list = priceSeatDAO.findOneById(id);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public Long insert(PriceSeatDTO priceSeatDTO) {
		return priceSeatDAO.insert(priceSeatDTO);
	}

	@Override
	public void update(PriceSeatDTO priceSeatDTO) {
		priceSeatDAO.update(priceSeatDTO);
	}

	@Override
	public void delete(String id) {
		priceSeatDAO.delete(id);
	}
	
}
