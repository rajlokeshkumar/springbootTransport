package com.codenotfound.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "driverInfo")
public class DriverInfo {
@DynamoDBAttribute
private String driverName; 
@DynamoDBHashKey
private String licenseno;
@DynamoDBAttribute
private String joiningdate;
@DynamoDBAttribute
private String mobileNumber;
@DynamoDBAttribute
private String secondaryno;
@DynamoDBAttribute
private String address;
public String getDriverName() {
	return driverName;
}
public void setDriverName(String driverName) {
	this.driverName = driverName;
}
public String getLicenseno() {
	return licenseno;
}
public void setLicenseno(String licenseno) {
	this.licenseno = licenseno;
}
public String getJoiningdate() {
	return joiningdate;
}
public void setJoiningdate(String joiningdate) {
	this.joiningdate = joiningdate;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getSecondaryno() {
	return secondaryno;
}
public void setSecondaryno(String secondaryno) {
	this.secondaryno = secondaryno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}
