package com.planeticket.dto;

public class FlightDTO {
	private String id;
	private Integer idRoute;
	private RouteDTO routeDTO = new RouteDTO(); 
	private String idPlane;
	private PlaneDTO planeDTO = new PlaneDTO(); 
	private String dateStart;
	private String dateEnd;
	
	private Integer idPriceSeat;
	private PriceSeatDTO priceSeat = new PriceSeatDTO();
	
	private String codeFrom;
	private String codeTo;
	private Integer economy;
	private Integer business;
	private Integer firstClass;
	public Integer getIdPriceSeat() {
		return idPriceSeat;
	}
	public void setIdPriceSeat(Integer idPriceSeat) {
		this.idPriceSeat = idPriceSeat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIdRoute() {
		return idRoute;
	}
	public void setIdRoute(Integer idRoute) {
		this.idRoute = idRoute;
	}
	public RouteDTO getRouteDTO() {
		return routeDTO;
	}
	public void setRouteDTO(RouteDTO routeDTO) {
		this.routeDTO = routeDTO;
	}
	public String getIdPlane() {
		return idPlane;
	}
	public void setIdPlane(String idPlane) {
		this.idPlane = idPlane;
	}
	public PlaneDTO getPlaneDTO() {
		return planeDTO;
	}
	public void setPlaneDTO(PlaneDTO planeDTO) {
		this.planeDTO = planeDTO;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public PriceSeatDTO getPriceSeat() {
		return priceSeat;
	}
	public void setPriceSeat(PriceSeatDTO priceSeat) {
		this.priceSeat = priceSeat;
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
		return "FlightDTO [id=" + id + ", idRoute=" + idRoute + ", routeDTO=" + routeDTO + ", idPlane=" + idPlane
				+ ", planeDTO=" + planeDTO + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", idPriceSeat="
				+ idPriceSeat + ", priceSeat=" + priceSeat + ", codeFrom=" + codeFrom + ", codeTo=" + codeTo
				+ ", economy=" + economy + ", business=" + business + ", firstClass=" + firstClass + "]";
	}
}
