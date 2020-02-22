package com.codenotfound.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryResponseDto {
	@SerializedName("Id")
	@Expose
	private int id;
	@SerializedName("Name")
	@Expose
	private String name;

	@SerializedName("RiverBedName")
	@Expose
	private String riverBedName;
	@SerializedName("RevenueVillageName")
	@Expose
	private String revenueVillageName;
	
	@SerializedName("District")
	@Expose
	private String district;
	
	@SerializedName("RunningQueueNumber")
	@Expose
	private int runningQueueNumber;
	@SerializedName("BalanceSandUnits")
	@Expose
	private int balanceSandUnits;
	@SerializedName("QuarryTypeName")
	@Expose
	private String quarryTypeName;
	
	
	
	public String getQuarryTypeName() {
		return quarryTypeName;
	}
	public void setQuarryTypeName(String quarryTypeName) {
		this.quarryTypeName = quarryTypeName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public int getRunningQueueNumber() {
		return runningQueueNumber;
	}
	public void setRunningQueueNumber(int runningQueueNumber) {
		this.runningQueueNumber = runningQueueNumber;
	}
	public int getBalanceSandUnits() {
		return balanceSandUnits;
	}
	public void setBalanceSandUnits(int balanceSandUnits) {
		this.balanceSandUnits = balanceSandUnits;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRiverBedName() {
		return riverBedName;
	}
	public void setRiverBedName(String riverBedName) {
		this.riverBedName = riverBedName;
	}
	public String getRevenueVillageName() {
		return revenueVillageName;
	}
	public void setRevenueVillageName(String revenueVillageName) {
		this.revenueVillageName = revenueVillageName;
	}
	
	
	
}
