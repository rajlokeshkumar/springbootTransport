package com.codenotfound.entity;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AtmCreditDebit implements DynamoDBTypeConverter<String, List<AtmCreditDebit>> {

	private Date date;

	private BigDecimal amount;

	private String paymentMode;

	private String rowID;

	public String getRowID() {
		return rowID;
	}

	public void setRowID(String rowID) {
		this.rowID = rowID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String convert(List<AtmCreditDebit> arg0) {
		// Jackson object mapper
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String objectsString = objectMapper.writeValueAsString(arg0);
			return objectsString;
		} catch (JsonProcessingException e) {
			// do something
		}
		return null;
	}

	@Override
	public List<AtmCreditDebit> unconvert(String arg0) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<AtmCreditDebit> objects = objectMapper.readValue(arg0, new TypeReference<List<AtmCreditDebit>>() {
			});
			return objects;
		} catch (JsonParseException e) {
			// do something
		} catch (JsonMappingException e) {
			// do something
		} catch (IOException e) {
			// do something
		}
		return null;
	}

	public AtmCreditDebit() {
	}

}
