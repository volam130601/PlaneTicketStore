package com.planeticket.dto;

public class SeatDTO {
	private String id; 
	private String idPlane;
	private String idType;
	private boolean status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdPlane() {
		return idPlane;
	}
	public void setIdPlane(String idPlane) {
		this.idPlane = idPlane;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SeatDTO [id=" + id + ", idPlane=" + idPlane + ", idType=" + idType + ", status=" + status + "]";
	}
}
