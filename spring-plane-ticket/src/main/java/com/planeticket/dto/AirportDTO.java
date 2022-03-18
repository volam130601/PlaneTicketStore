package com.planeticket.dto;


public class AirportDTO {
	private Integer id;
	private String code;
	private String name;
	private String country;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "AirportDTO [id=" + id + ", code=" + code + ", name=" + name + ", country=" + country + "]";
	}
}
