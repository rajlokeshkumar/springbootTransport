package com.codenotfound.dto;

import java.util.Date;

public class BookingDto {

	private String ownerName;
	
	private String lorryNo;
	
	private Long mobileNo;
	
	private String bookingScript;
	
	private String paymentScript;
	
	private int queueNumber;
	
	private Date currentBookingDate;
	
	private Date nextBookingDate;
	
	private String assignedName;
	
	private String paymentStatus;
	
	private String queryToBook;
	
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
