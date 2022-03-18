package com.planeticket.dto;

import java.util.Date;

public class CustemorDTO {
	private Integer id;
	private String fullName;
	private Date birthday;
	private String cccd;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustemorDTO [id=" + id + ", fullName=" + fullName + ", birthday=" + birthday + ", cccd=" + cccd
				+ ", address=" + address + "]";
	}
}
