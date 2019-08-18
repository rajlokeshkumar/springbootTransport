package com.codenotfound.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TripRegisterDto {
	
private String id;	

private String vechileNumber;

private String driverName1;

private String driverName2;

private String cleanerName;

private String startPlace;

private String endPlace;

private BigDecimal vehicleAdvance;

private String goodsName;

private Integer goodsTotalWeight;

private Integer hireprice;

private BigDecimal amountpaidonLoad;

private BigDecimal amountPaidonOffload;

private Integer totalNumberofKM;

private List<FuelDto> fuelDto;

private List<ExpenseOnTripBilledDto> expenseOnTripBilled;

private List<ExpenseonRTOandTOLLDto> expenseonRTOandTOLL;

private BigDecimal commissionAsBilled;

private BigDecimal totalDieselAmount;

private BigDecimal totalDriverWageForTrip;

private BigDecimal cleanerWage;

private BigDecimal totalexpenseonRTOandTOLL;

private BigDecimal expenseForLoading;

private BigDecimal expenseForunloading;

private BigDecimal totalTollExpense;

private Integer totalunBilledExpense;

private BigDecimal totalExpenseForTrip;

private BigDecimal totalIncome;

private Integer totalprofitOnTrip;

private Date tripStartDate;

private Date tripEndDate;

private BigDecimal totalBilledExpense;

private BigDecimal otherExpense;

private String statusOfTrip;

private BigDecimal billedtollExpense;

private BigDecimal drivertoGive;

private List<Advancedto> advancedtos;



public List<Advancedto> getAdvancedtos() {
	return advancedtos;
}

public void setAdvancedtos(List<Advancedto> advancedtos) {
	this.advancedtos = advancedtos;
}

public BigDecimal getDrivertoGive() {
	return drivertoGive;
}

public void setDrivertoGive(BigDecimal drivertoGive) {
	this.drivertoGive = drivertoGive;
}

public BigDecimal getBilledtollExpense() {
	return billedtollExpense;
}

public void setBilledtollExpense(BigDecimal billedtollExpense) {
	this.billedtollExpense = billedtollExpense;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getStatusOfTrip() {
	return statusOfTrip;
}

public void setStatusOfTrip(String statusOfTrip) {
	this.statusOfTrip = statusOfTrip;
}

public BigDecimal getOtherExpense() {
	return otherExpense;
}

public void setOtherExpense(BigDecimal otherExpense) {
	this.otherExpense = otherExpense;
}

public BigDecimal getTotalBilledExpense() {
	return totalBilledExpense;
}

public void setTotalBilledExpense(BigDecimal totalBilledExpense) {
	this.totalBilledExpense = totalBilledExpense;
}

public Date getTripStartDate() {
	return tripStartDate;
}

public void setTripStartDate(Date tripStartDate) {
	this.tripStartDate = tripStartDate;
}

public Date getTripEndDate() {
	return tripEndDate;
}

public void setTripEndDate(Date tripEndDate) {
	this.tripEndDate = tripEndDate;
}

public String getVechileNumber() {
	return vechileNumber;
}

public void setVechileNumber(String vechileNumber) {
	this.vechileNumber = vechileNumber;
}

public String getDriverName1() {
	return driverName1;
}

public void setDriverName1(String driverName1) {
	this.driverName1 = driverName1;
}

public String getDriverName2() {
	return driverName2;
}

public void setDriverName2(String driverName2) {
	this.driverName2 = driverName2;
}

public String getCleanerName() {
	return cleanerName;
}

public void setCleanerName(String cleanerName) {
	this.cleanerName = cleanerName;
}

public String getStartPlace() {
	return startPlace;
}

public void setStartPlace(String startPlace) {
	this.startPlace = startPlace;
}

public String getEndPlace() {
	return endPlace;
}

public void setEndPlace(String endPlace) {
	this.endPlace = endPlace;
}

public BigDecimal getVehicleAdvance() {
	return vehicleAdvance;
}

public void setVehicleAdvance(BigDecimal vehicleAdvance) {
	this.vehicleAdvance = vehicleAdvance;
}

public String getGoodsName() {
	return goodsName;
}

public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}

public Integer getGoodsTotalWeight() {
	return goodsTotalWeight;
}

public void setGoodsTotalWeight(Integer goodsTotalWeight) {
	this.goodsTotalWeight = goodsTotalWeight;
}

public Integer getHireprice() {
	return hireprice;
}

public void setHireprice(Integer hireprice) {
	this.hireprice = hireprice;
}

public BigDecimal getAmountpaidonLoad() {
	return amountpaidonLoad;
}

public void setAmountpaidonLoad(BigDecimal amountpaidonLoad) {
	this.amountpaidonLoad = amountpaidonLoad;
}

public BigDecimal getAmountPaidonOffload() {
	return amountPaidonOffload;
}

public void setAmountPaidonOffload(BigDecimal amountPaidonOffload) {
	this.amountPaidonOffload = amountPaidonOffload;
}

public Integer getTotalNumberofKM() {
	return totalNumberofKM;
}

public void setTotalNumberofKM(Integer totalNumberofKM) {
	this.totalNumberofKM = totalNumberofKM;
}

public List<FuelDto> getFuelDto() {
	return fuelDto;
}

public void setFuelDto(List<FuelDto> fuelDto) {
	this.fuelDto = fuelDto;
}

public List<ExpenseOnTripBilledDto> getExpenseOnTripBilled() {
	return expenseOnTripBilled;
}

public void setExpenseOnTripBilled(List<ExpenseOnTripBilledDto> expenseOnTripBilled) {
	this.expenseOnTripBilled = expenseOnTripBilled;
}

public List<ExpenseonRTOandTOLLDto> getExpenseonRTOandTOLL() {
	return expenseonRTOandTOLL;
}

public void setExpenseonRTOandTOLL(List<ExpenseonRTOandTOLLDto> expenseonRTOandTOLL) {
	this.expenseonRTOandTOLL = expenseonRTOandTOLL;
}

public BigDecimal getCommissionAsBilled() {
	return commissionAsBilled;
}

public void setCommissionAsBilled(BigDecimal commissionAsBilled) {
	this.commissionAsBilled = commissionAsBilled;
}

public BigDecimal getTotalDieselAmount() {
	return totalDieselAmount;
}

public void setTotalDieselAmount(BigDecimal totalDieselAmount) {
	this.totalDieselAmount = totalDieselAmount;
}

public BigDecimal getTotalDriverWageForTrip() {
	return totalDriverWageForTrip;
}

public void setTotalDriverWageForTrip(BigDecimal totalDriverWageForTrip) {
	this.totalDriverWageForTrip = totalDriverWageForTrip;
}

public BigDecimal getCleanerWage() {
	return cleanerWage;
}

public void setCleanerWage(BigDecimal cleanerWage) {
	this.cleanerWage = cleanerWage;
}

public BigDecimal getTotalexpenseonRTOandTOLL() {
	return totalexpenseonRTOandTOLL;
}

public void setTotalexpenseonRTOandTOLL(BigDecimal totalexpenseonRTOandTOLL) {
	this.totalexpenseonRTOandTOLL = totalexpenseonRTOandTOLL;
}

public BigDecimal getExpenseForLoading() {
	return expenseForLoading;
}

public void setExpenseForLoading(BigDecimal expenseForLoading) {
	this.expenseForLoading = expenseForLoading;
}

public BigDecimal getExpenseForunloading() {
	return expenseForunloading;
}

public void setExpenseForunloading(BigDecimal expenseForunloading) {
	this.expenseForunloading = expenseForunloading;
}

public BigDecimal getTotalTollExpense() {
	return totalTollExpense;
}

public void setTotalTollExpense(BigDecimal totalTollExpense) {
	this.totalTollExpense = totalTollExpense;
}

public Integer getTotalunBilledExpense() {
	return totalunBilledExpense;
}

public void setTotalunBilledExpense(Integer totalunBilledExpense) {
	this.totalunBilledExpense = totalunBilledExpense;
}

public BigDecimal getTotalExpenseForTrip() {
	return totalExpenseForTrip;
}

public void setTotalExpenseForTrip(BigDecimal totalExpenseForTrip) {
	this.totalExpenseForTrip = totalExpenseForTrip;
}

public BigDecimal getTotalIncome() {
	return totalIncome;
}

public void setTotalIncome(BigDecimal totalIncome) {
	this.totalIncome = totalIncome;
}

public Integer getTotalprofitOnTrip() {
	return totalprofitOnTrip;
}

public void setTotalprofitOnTrip(Integer totalprofitOnTrip) {
	this.totalprofitOnTrip = totalprofitOnTrip;
}


	
}
