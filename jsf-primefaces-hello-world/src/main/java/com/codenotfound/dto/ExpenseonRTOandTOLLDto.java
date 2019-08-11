package com.codenotfound.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseonRTOandTOLLDto {

private Constants expenseType;

private String placeofExpense;

private String stateofExpense;

private BigDecimal amountOfExpense;

private String rowID;

private Date expenseDate;



public Date getExpenseDate() {
	return expenseDate;
}

public void setExpenseDate(Date expenseDate) {
	this.expenseDate = expenseDate;
}

public String getRowID() {
	return rowID;
}

public void setRowID(String rowID) {
	this.rowID = rowID;
}

public Constants getExpenseType() {
	return expenseType;
}

public void setExpenseType(Constants expenseType) {
	this.expenseType = expenseType;
}

public String getPlaceofExpense() {
	return placeofExpense;
}

public void setPlaceofExpense(String placeofExpense) {
	this.placeofExpense = placeofExpense;
}

public String getStateofExpense() {
	return stateofExpense;
}

public void setStateofExpense(String stateofExpense) {
	this.stateofExpense = stateofExpense;
}

public BigDecimal getAmountOfExpense() {
	return amountOfExpense;
}

public void setAmountOfExpense(BigDecimal amountOfExpense) {
	this.amountOfExpense = amountOfExpense;
}


	
}
