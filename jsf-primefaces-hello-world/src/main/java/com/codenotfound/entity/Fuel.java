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

public class Fuel implements  DynamoDBTypeConverter<String, List<Fuel>>{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private String placeoffuel;

private BigDecimal NumberofLitre;

private BigDecimal pricePerlitre;

private String state;

private String paymentMode;

private BigDecimal totalAmount;

private String rowID;

private Date dateOfTransaction;




public Date getDateOfTransaction() {
	return dateOfTransaction;
}

public void setDateOfTransaction(Date dateOfTransaction) {
	this.dateOfTransaction = dateOfTransaction;
}

public String getRowID() {
	return rowID;
}

public void setRowID(String rowID) {
	this.rowID = rowID;
}

public BigDecimal getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(BigDecimal totalAmount) {
	this.totalAmount = totalAmount;
}

public String getPlaceoffuel() {
	return placeoffuel;
}

public void setPlaceoffuel(String placeoffuel) {
	this.placeoffuel = placeoffuel;
}

public BigDecimal getNumberofLitre() {
	return NumberofLitre;
}

public void setNumberofLitre(BigDecimal numberofLitre) {
	NumberofLitre = numberofLitre;
}

public BigDecimal getPricePerlitre() {
	return pricePerlitre;
}

public void setPricePerlitre(BigDecimal pricePerlitre) {
	this.pricePerlitre = pricePerlitre;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getPaymentMode() {
	return paymentMode;
}

public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
}

@Override
public String convert(List<Fuel> arg0) {
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
public List<Fuel> unconvert(String arg0) {
	 ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        List<Fuel> objects = objectMapper.readValue(arg0, new TypeReference<List<Fuel>>(){});
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

public Fuel() {

}



}
