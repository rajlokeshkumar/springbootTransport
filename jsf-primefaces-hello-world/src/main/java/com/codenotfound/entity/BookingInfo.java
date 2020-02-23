package com.codenotfound.entity;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
@DynamoDBTable(tableName = "bookingInfo")
public class BookingInfo {
	@DynamoDBAttribute
	private String ownerName;
	@DynamoDBHashKey
	private String lorryNo;
	@DynamoDBAttribute
	private Long mobileNo;
	@DynamoDBAttribute
	private String bookingScript;
	@DynamoDBAttribute
	private String paymentScript;
	@DynamoDBAttribute
	private int queueNumber;
	@DynamoDBAttribute
	private Date currentBookingDate;
	@DynamoDBAttribute
	private Date nextBookingDate;
	@DynamoDBAttribute
	private String assignedName;
	@DynamoDBAttribute
	private String paymentStatus;
	@DynamoDBAttribute
	private String queryToBook;
	@DynamoDBAttribute
	private Long paymentAmount;


	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getQueryToBook() {
		return queryToBook;
	}

	public void setQueryToBook(String queryToBook) {
		this.queryToBook = queryToBook;
	}

	public Long getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Long paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getAssignedName() {
		return assignedName;
	}

	public void setAssignedName(String assignedName) {
		this.assignedName = assignedName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLorryNo() {
		return lorryNo;
	}

	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getBookingScript() {
		return bookingScript;
	}

	public void setBookingScript(String bookingScript) {
		this.bookingScript = bookingScript;
	}

	public String getPaymentScript() {
		return paymentScript;
	}

	public void setPaymentScript(String paymentScript) {
		this.paymentScript = paymentScript;
	}

	public int getQueueNumber() {
		return queueNumber;
	}

	public void setQueueNumber(int queueNumber) {
		this.queueNumber = queueNumber;
	}

	public Date getCurrentBookingDate() {
		return currentBookingDate;
	}

	public void setCurrentBookingDate(Date currentBookingDate) {
		this.currentBookingDate = currentBookingDate;
	}

	public Date getNextBookingDate() {
		return nextBookingDate;
	}

	public void setNextBookingDate(Date nextBookingDate) {
		this.nextBookingDate = nextBookingDate;
	}
	
	
}
