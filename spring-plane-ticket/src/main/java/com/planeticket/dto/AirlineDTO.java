package com.planeticket.dto;


public class AirlineDTO {
	private String id;
	private String name;
	private String description;
	private String logo;
	private String status;
	@Override
	public String toString() {
		return "AirlineDTO [id=" + id + ", name=" + name + ", description=" + description + ", logo=" + logo
				+ ", status=" + status + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
