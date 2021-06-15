package com.ykpay.api.charging.model;

public class Charging {
	private String connectionUser;
	private int totalPoint;
	private int chargingPoint;
	private String chargingRegdate;
	
	public Charging() {
	}

	public String getConnectionUser() {
		return connectionUser;
	}

	public void setConnectionUser(String connectionUser) {
		this.connectionUser = connectionUser;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public int getChargingPoint() {
		return chargingPoint;
	}

	public void setChargingPoint(int chargingPoint) {
		this.chargingPoint = chargingPoint;
	}

	public String getChargingRegdate() {
		return chargingRegdate;
	}

	public void setChargingRegdate(String chargingRegdate) {
		this.chargingRegdate = chargingRegdate;
	}

	public Charging(String connectionUser, int totalPoint, int chargingPoint, String chargingRegdate) {
		super();
		this.connectionUser = connectionUser;
		this.totalPoint = totalPoint;
		this.chargingPoint = chargingPoint;
		this.chargingRegdate = chargingRegdate;
	}
	
	
	
}
