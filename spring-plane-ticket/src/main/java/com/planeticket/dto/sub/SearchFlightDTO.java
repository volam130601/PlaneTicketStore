package com.planeticket.dto.sub;


public class SearchFlightDTO {
	private String codeFrom;
	private String codeTo;
	private String dateLeave;
	private String dateComeBack;
	private String typePassenger;
	private String typeSeat;
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
	public String getDateLeave() {
		return dateLeave;
	}
	public void setDateLeave(String dateLeave) {
		this.dateLeave = dateLeave;
	}
	public String getDateComeBack() {
		return dateComeBack;
	}
	public void setDateComeBack(String dateComeBack) {
		this.dateComeBack = dateComeBack;
	}
	public String getTypePassenger() {
		return typePassenger;
	}
	public void setTypePassenger(String typePassenger) {
		this.typePassenger = typePassenger;
	}
	public String getTypeSeat() {
		return typeSeat;
	}
	public void setTypeSeat(String typeSeat) {
		this.typeSeat = typeSeat;
	}
	@Override
	public String toString() {
		return "SearchFlightDTO [codeFrom=" + codeFrom + ", codeTo=" + codeTo + ", dateLeave=" + dateLeave
				+ ", dateComeBack=" + dateComeBack + ", typePassenger=" + typePassenger + ", typeSeat=" + typeSeat
				+ "]";
	}
}
