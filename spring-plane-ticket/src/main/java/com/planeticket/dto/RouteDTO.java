package com.planeticket.dto;


public class RouteDTO {
	private Integer id;
	private String codeFrom;
	private String codeTo;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodeFrom() {
		return codeFrom;
	}
	public void setCodeFrom(String codeFrom) {
		this.codeFrom = codeFrom;
	}
	public String getCodeTo() {
		return codeTo;
	}
	public void setCodeTo(String codeTo) {
		this.codeTo = codeTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RouteDTO [id=" + id + ", codeFrom=" + codeFrom + ", codeTo=" + codeTo + ", status=" + status + "]";
	}
}
