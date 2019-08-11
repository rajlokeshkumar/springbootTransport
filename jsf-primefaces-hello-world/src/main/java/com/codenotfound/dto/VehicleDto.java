package com.codenotfound.dto;

import java.util.Date;

public class VehicleDto {

	private String registrationNumber;
	
	private String chasisNumber;
	
	private String model;
	
	private Date insuranceDate;
	
	private Date npTaxDate;
	
	private Date quaterTaxDate;
	
	private String engineNumber;
	
	private String axile;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getChasisNumber() {
		return chasisNumber;
	}

	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}



	public Date getInsuranceDate() {
		return insuranceDate;
	}

	public void setInsuranceDate(Date insuranceDate) {
		this.insuranceDate = insuranceDate;
	}

	public Date getNpTaxDate() {
		return npTaxDate;
	}

	public void setNpTaxDate(Date npTaxDate) {
		this.npTaxDate = npTaxDate;
	}

	public Date getQuaterTaxDate() {
		return quaterTaxDate;
	}

	public void setQuaterTaxDate(Date quaterTaxDate) {
		this.quaterTaxDate = quaterTaxDate;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getAxile() {
		return axile;
	}

	public void setAxile(String axile) {
		this.axile = axile;
	}
	
	
	
	
}
