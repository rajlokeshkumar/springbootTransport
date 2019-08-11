package com.codenotfound.entity;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "vehicle")
public class Vehicle {

	@DynamoDBHashKey
	private String registrationNumber;
	@DynamoDBAttribute
	private String chasisNumber;
	@DynamoDBAttribute
	private String model;
	@DynamoDBAttribute
	private Date insuranceDate;
	@DynamoDBAttribute
	private Date npTaxDate;
	@DynamoDBAttribute
	private Date quaterTaxDate;
	@DynamoDBAttribute
	private String engineNumber;
	@DynamoDBAttribute
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
