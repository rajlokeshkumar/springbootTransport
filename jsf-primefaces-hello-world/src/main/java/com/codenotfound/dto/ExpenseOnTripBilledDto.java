package com.codenotfound.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseOnTripBilledDto {

	private String purposeOfBill;
	
	private BigDecimal amountpaid;
	
	private boolean expenseBilled;

	private String rowID;
	
	private Date expenseBilledDate;
	
	
	
	public Date getExpenseBilledDate() {
		return expenseBilledDate;
	}

	public void setExpenseBilledDate(Date expenseBilledDate) {
		this.expenseBilledDate = expenseBilledDate;
	}

	public String getPurposeOfBill() {
		return purposeOfBill;
	}

	public void setPurposeOfBill(String purposeOfBill) {
		this.purposeOfBill = purposeOfBill;
	}

	public BigDecimal getAmountpaid() {
		return amountpaid;
	}

	public void setAmountpaid(BigDecimal amountpaid) {
		this.amountpaid = amountpaid;
	}

	public boolean isExpenseBilled() {
		return expenseBilled;
	}

	public void setExpenseBilled(boolean expenseBilled) {
		this.expenseBilled = expenseBilled;
	}

	public String getRowID() {
		return rowID;
	}

	public void setRowID(String rowID) {
		this.rowID = rowID;
	}
	
	
	
}
