package com.planeticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planeticket.dao.IFlightDAO;
import com.planeticket.dto.FlightDTO;
import com.planeticket.dto.PriceSeatDTO;
import com.planeticket.dto.RouteDTO;
import com.planeticket.service.IFlightService;
import com.planeticket.service.IPriceSeatService;
import com.planeticket.service.IRouteService;
import com.planeticket.util.RandomString;

@Service
public class FlightService implements IFlightService {

	@Autowired
	private IFlightDAO flightDAO;
	
	@Autowired
	private IFlightService flightService;

	@Autowired
	private IRouteService routeService;

	@Autowired
	private RandomString random;

	@Autowired
	private IPriceSeatService priceSeatService;
	

	@Override
	public List<FlightDTO> findAll() {
		return flightDAO.findAll();
	}

	@Override
	public FlightDTO findOneById(String id) {
		List<FlightDTO> models = flightDAO.findOneById(id);
		return models.isEmpty() ? null : models.get(0);
	}

	@Override
	public FlightDTO insertCode(FlightDTO flightDTO) {
		RouteDTO route = routeService.findOneByCodeFromAndCodeTo(flightDTO.getCodeFrom(), flightDTO.getCodeTo());
		flightDTO.setIdRoute(route.getId());
		FlightDTO checkIdFlight = null;
		int flag =0;
		do {
			flightDTO.setId(random.getRandom());
			checkIdFlight = flightService.findOneById(flightDTO.getId());
			if(checkIdFlight == null) {
				//Loc trung ma chuyen bay: delay
				PriceSeatDTO priceSeatDTO = new PriceSeatDTO();
				priceSeatDTO.setEconomy(flightDTO.getEconomy());
				priceSeatDTO.setBusiness(flightDTO.getBusiness());
				priceSeatDTO.setFirstClass(flightDTO.getFirstClass());
				
				Long idPriceSeat = priceSeatService.insert(priceSeatDTO);
				flightDTO.setIdPriceSeat(Integer.parseInt(idPriceSeat.toString()));
				
				flag++;
				break;
			}
		}while(checkIdFlight != null);
		if(flag != 0) 
			return flightDAO.insertCode(flightDTO);
		return null;
	}

	@Override
	public FlightDTO udpate(FlightDTO flightDTO) {
		RouteDTO route = routeService.findOneByCodeFromAndCodeTo(flightDTO.getCodeFrom(), flightDTO.getCodeTo());
		flightDTO.setIdRoute(route.getId());
		PriceSeatDTO priceSeatDTO = new PriceSeatDTO();
		priceSeatDTO.setId(flightDTO.getIdPriceSeat());
		priceSeatDTO.setEconomy(flightDTO.getEconomy());
		priceSeatDTO.setBusiness(flightDTO.getBusiness());
		priceSeatDTO.setFirstClass(flightDTO.getFirstClass());
		priceSeatService.update(priceSeatDTO);
		flightDAO.udpate(flightDTO);
		return flightDTO;
	}

	@Override
	public void delete(String id) {
		FlightDTO flightDTO = flightService.findOneById(id);
		flightDAO.delete(id);
		priceSeatService.delete(flightDTO.getIdPriceSeat().toString());
	}
}
