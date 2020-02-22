package com.codenotfound.dto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryDto {

	@SerializedName("Id")
	@Expose
	private int id;
	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("QuarryTypeId")
	@Expose
	private int quarryTypeId;
	@SerializedName("RiverBedName")
	@Expose
	private String riverBedName;
	@SerializedName("RevenueVillageName")
	@Expose
	private String revenueVillageName;
	@SerializedName("Taluk")
	@Expose
	private String taluk;
	@SerializedName("District")
	@Expose
	private String district;
	@SerializedName("SurveyNumber")
	@Expose
	private String surveyNumber;
	@SerializedName("DailyCapacity")
	@Expose
	private int dailyCapacity;
	@SerializedName("SandPricePerUnit")
	@Expose
	private int sandPricePerUnit;
	@SerializedName("Latitude")
	@Expose
	private double latitude;
	@SerializedName("Longitude")
	@Expose
	private double longitude;
	@SerializedName("IsActive")
	@Expose
	private boolean isActive;
	@SerializedName("EstimatedDays")
	@Expose
	private int estimatedDays;
	@SerializedName("QuarryTypeName")
	@Expose
	private String quarryTypeName;
	@SerializedName("RunningQueueNumber")
	@Expose
	private int runningQueueNumber;
	@SerializedName("DistrictId")
	@Expose
	private int districtId;
	@SerializedName("PermitHolderName")
	@Expose
	private Object permitHolderName;
	@SerializedName("PermitHolderAddress")
	@Expose
	private Object permitHolderAddress;
	@SerializedName("OrderNumber")
	@Expose
	private Object orderNumber;
	@SerializedName("OrderDate")
	@Expose
	private String orderDate;
	@SerializedName("ExpiryDate")
	@Expose
	private String expiryDate;
	@SerializedName("MineralName")
	@Expose
	private Object mineralName;
	@SerializedName("QuarryStatusId")
	@Expose
	private int quarryStatusId;
	@SerializedName("DefaultEta")
	@Expose
	private int defaultEta;
	@SerializedName("AllowMultiAxle")
	@Expose
	private boolean allowMultiAxle;
	@SerializedName("AllowCancel")
	@Expose
	private boolean allowCancel;
	@SerializedName("AllowMove")
	@Expose
	private boolean allowMove;
	@SerializedName("IsReachedMaximumUnit")
	@Expose
	private boolean isReachedMaximumUnit;
	@SerializedName("OrderCancelDayCount")
	@Expose
	private int orderCancelDayCount;
	@SerializedName("AllowSchedule")
	@Expose
	private boolean allowSchedule;
	@SerializedName("AllowableSandUnits")
	@Expose
	private int allowableSandUnits;
	@SerializedName("BalanceSandUnits")
	@Expose
	private int balanceSandUnits;
	@SerializedName("LastInactivatedDate")
	@Expose
	private Object lastInactivatedDate;
	@SerializedName("AcceptedOrderUnits")
	@Expose
	private int acceptedOrderUnits;
	@SerializedName("ConfimedOrderUnits")
	@Expose
	private int confimedOrderUnits;
	@SerializedName("CompletedOrderUnits")
	@Expose
	private int completedOrderUnits;
	@SerializedName("AllowRefund")
	@Expose
	private boolean allowRefund;
	@SerializedName("EncryptedId")
	@Expose
	private String encryptedId;
	@SerializedName("PostStatusMessage")
	@Expose
	private Object postStatusMessage;
	@SerializedName("PostStatus")
	@Expose
	private boolean postStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuarryTypeId() {
		return quarryTypeId;
	}

	public void setQuarryTypeId(int quarryTypeId) {
		this.quarryTypeId = quarryTypeId;
	}

	public String getRiverBedName() {
		return riverBedName;
	}

	public void setRiverBedName(String riverBedName) {
		this.riverBedName = riverBedName;
	}

	public String getRevenueVillageName() {
		return revenueVillageName;
	}

	public void setRevenueVillageName(String revenueVillageName) {
		this.revenueVillageName = revenueVillageName;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSurveyNumber() {
		return surveyNumber;
	}

	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}

	public int getDailyCapacity() {
		return dailyCapacity;
	}

	public void setDailyCapacity(int dailyCapacity) {
		this.dailyCapacity = dailyCapacity;
	}

	public int getSandPricePerUnit() {
		return sandPricePerUnit;
	}

	public void setSandPricePerUnit(int sandPricePerUnit) {
		this.sandPricePerUnit = sandPricePerUnit;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getEstimatedDays() {
		return estimatedDays;
	}

	public void setEstimatedDays(int estimatedDays) {
		this.estimatedDays = estimatedDays;
	}

	public String getQuarryTypeName() {
		return quarryTypeName;
	}

	public void setQuarryTypeName(String quarryTypeName) {
		this.quarryTypeName = quarryTypeName;
	}



	public int getRunningQueueNumber() {
		return runningQueueNumber;
	}

	public void setRunningQueueNumber(int runningQueueNumber) {
		this.runningQueueNumber = runningQueueNumber;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public Object getPermitHolderName() {
		return permitHolderName;
	}

	public void setPermitHolderName(Object permitHolderName) {
		this.permitHolderName = permitHolderName;
	}

	public Object getPermitHolderAddress() {
		return permitHolderAddress;
	}

	public void setPermitHolderAddress(Object permitHolderAddress) {
		this.permitHolderAddress = permitHolderAddress;
	}

	public Object getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Object orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Object getMineralName() {
		return mineralName;
	}

	public void setMineralName(Object mineralName) {
		this.mineralName = mineralName;
	}

	public int getQuarryStatusId() {
		return quarryStatusId;
	}

	public void setQuarryStatusId(int quarryStatusId) {
		this.quarryStatusId = quarryStatusId;
	}

	public int getDefaultEta() {
		return defaultEta;
	}

	public void setDefaultEta(int defaultEta) {
		this.defaultEta = defaultEta;
	}

	public boolean isAllowMultiAxle() {
		return allowMultiAxle;
	}

	public void setAllowMultiAxle(boolean allowMultiAxle) {
		this.allowMultiAxle = allowMultiAxle;
	}

	public boolean isAllowCancel() {
		return allowCancel;
	}

	public void setAllowCancel(boolean allowCancel) {
		this.allowCancel = allowCancel;
	}

	public boolean isAllowMove() {
		return allowMove;
	}

	public void setAllowMove(boolean allowMove) {
		this.allowMove = allowMove;
	}

	public boolean isIsReachedMaximumUnit() {
		return isReachedMaximumUnit;
	}

	public void setIsReachedMaximumUnit(boolean isReachedMaximumUnit) {
		this.isReachedMaximumUnit = isReachedMaximumUnit;
	}

	public int getOrderCancelDayCount() {
		return orderCancelDayCount;
	}

	public void setOrderCancelDayCount(int orderCancelDayCount) {
		this.orderCancelDayCount = orderCancelDayCount;
	}

	public boolean isAllowSchedule() {
		return allowSchedule;
	}

	public void setAllowSchedule(boolean allowSchedule) {
		this.allowSchedule = allowSchedule;
	}

	public int getAllowableSandUnits() {
		return allowableSandUnits;
	}

	public void setAllowableSandUnits(int allowableSandUnits) {
		this.allowableSandUnits = allowableSandUnits;
	}

	public int getBalanceSandUnits() {
		return balanceSandUnits;
	}

	public void setBalanceSandUnits(int balanceSandUnits) {
		this.balanceSandUnits = balanceSandUnits;
	}

	public Object getLastInactivatedDate() {
		return lastInactivatedDate;
	}

	public void setLastInactivatedDate(Object lastInactivatedDate) {
		this.lastInactivatedDate = lastInactivatedDate;
	}

	public int getAcceptedOrderUnits() {
		return acceptedOrderUnits;
	}

	public void setAcceptedOrderUnits(int acceptedOrderUnits) {
		this.acceptedOrderUnits = acceptedOrderUnits;
	}

	public int getConfimedOrderUnits() {
		return confimedOrderUnits;
	}

	public void setConfimedOrderUnits(int confimedOrderUnits) {
		this.confimedOrderUnits = confimedOrderUnits;
	}

	public int getCompletedOrderUnits() {
		return completedOrderUnits;
	}

	public void setCompletedOrderUnits(int completedOrderUnits) {
		this.completedOrderUnits = completedOrderUnits;
	}

	public boolean isAllowRefund() {
		return allowRefund;
	}

	public void setAllowRefund(boolean allowRefund) {
		this.allowRefund = allowRefund;
	}

	public String getEncryptedId() {
		return encryptedId;
	}

	public void setEncryptedId(String encryptedId) {
		this.encryptedId = encryptedId;
	}

	public Object getPostStatusMessage() {
		return postStatusMessage;
	}

	public void setPostStatusMessage(Object postStatusMessage) {
		this.postStatusMessage = postStatusMessage;
	}

	public boolean isPostStatus() {
		return postStatus;
	}

	public void setPostStatus(boolean postStatus) {
		this.postStatus = postStatus;
	}
}
