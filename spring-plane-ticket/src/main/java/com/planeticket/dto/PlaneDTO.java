package com.planeticket.dto;


public class PlaneDTO {
	private String id;
	private String idAirline;
	private AirlineDTO airlineDTO = new AirlineDTO();
	private String status;
	private Integer totalSeat;
	private String factory;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdAirline() {
		return idAirline;
	}
	public void setIdAirline(String idAirline) {
		this.idAirline = idAirline;
	}
	public AirlineDTO getAirlineDTO() {
		return airlineDTO;
	}
	public void setAirlineDTO(AirlineDTO airlineDTO) {
		this.airlineDTO = airlineDTO;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(Integer totalSeat) {
		this.totalSeat = totalSeat;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	@Override
	public String toString() {
		return "PlaneDTO [id=" + id + ", idAirline=" + idAirline + ", airlineDTO=" + airlineDTO + ", status=" + status
				+ ", totalSeat=" + totalSeat + ", factory=" + factory + "]";
	}
}
