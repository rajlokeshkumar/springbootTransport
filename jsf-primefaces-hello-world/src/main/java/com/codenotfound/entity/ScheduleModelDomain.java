package com.codenotfound.entity;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
@DynamoDBTable(tableName = "schedule")
public class ScheduleModelDomain {
	
	@DynamoDBHashKey
	private String id;
	@DynamoDBAttribute
	private String title;
	@DynamoDBAttribute
	private Date startDate;
	@DynamoDBAttribute
	private Date endDate;
	@DynamoDBAttribute
	private boolean allDay = false;
	@DynamoDBAttribute
	private String styleClass;
	@DynamoDBAttribute
	private String data;
	@DynamoDBAttribute
	private boolean editable = true;
	@DynamoDBAttribute
	private String description;
	@DynamoDBAttribute
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}



	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
