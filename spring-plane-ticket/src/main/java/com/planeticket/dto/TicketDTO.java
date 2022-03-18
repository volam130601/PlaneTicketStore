package com.planeticket.dto;

public class TicketDTO {
	private Integer id;
	private Integer idFlight;
	private String idSeat;
	private Integer idCustomer;
	private String passengerType;
	private boolean status;
	private Integer idAirpot;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(Integer idFlight) {
		this.idFlight = idFlight;
	}
	public String getIdSeat() {
		return idSeat;
	}
	public void setIdSeat(String idSeat) {
		this.idSeat = idSeat;
	}
	public Integer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Integer getIdAirpot() {
		return idAirpot;
	}
	public void setIdAirpot(Integer idAirpot) {
		this.idAirpot = idAirpot;
	}
	@Override
	public String toString() {
		return "TicketDTO [id=" + id + ", idFlight=" + idFlight + ", idSeat=" + idSeat + ", idCustomer=" + idCustomer
				+ ", passengerType=" + passengerType + ", status=" + status + ", idAirpot=" + idAirpot + "]";
	}
}
