package com.codenotfound.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AtmCreditDebitDto {

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

	
	
	
}
