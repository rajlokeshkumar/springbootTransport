package com.codenotfound.entity;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Advance implements  DynamoDBTypeConverter<String, List<Advance>>  {


	private String purpose;
	
	private BigDecimal amount;

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	private String rowID;

	public String getRowID() {
		return rowID;
	}

	public void setRowID(String rowID) {
		this.rowID = rowID;
	}

	@Override
	public String convert(List<Advance> arg0) {
	    //Jackson object mapper
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        String objectsString = objectMapper.writeValueAsString(arg0);
	        return objectsString;
	    } catch (JsonProcessingException e) {
	        //do something
	    }
	    return null;
	}

	@Override
	public List<Advance> unconvert(String arg0) {
		 ObjectMapper objectMapper = new ObjectMapper();
		    try {
		        List<Advance> objects = objectMapper.readValue(arg0, new TypeReference<List<Advance>>(){});
		        return objects;
		    } catch (JsonParseException e) {
		        //do something
		    } catch (JsonMappingException e) {
		        //do something
		    } catch (IOException e) {
		        //do something
		    }
		    return null;
	}

	public Advance() {
	}

	
	
	
	
	
	

}
