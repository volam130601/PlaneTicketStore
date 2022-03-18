package com.planeticket.dto;


public class PriceSeatDTO {
	private Integer id;
	private Integer economy;
	private Integer business;
	private Integer firstClass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEconomy() {
		return economy;
	}
	public void setEconomy(Integer economy) {
		this.economy = economy;
	}
	public Integer getBusiness() {
		return business;
	}
	public void setBusiness(Integer business) {
		this.business = business;
	}
	public Integer getFirstClass() {
		return firstClass;
	}
	public void setFirstClass(Integer firstClass) {
		this.firstClass = firstClass;
	}
	@Override
	public String toString() {
		return "PriceSeatDTO [id=" + id + ", economy=" + economy + ", business=" + business + ", firstClass="
				+ firstClass + "]";
	}
}
