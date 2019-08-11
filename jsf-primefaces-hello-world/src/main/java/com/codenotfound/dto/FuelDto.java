package com.codenotfound.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FuelDto implements Serializable {

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


}
