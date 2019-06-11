package com.cts.creditcard.model;

public class MemberStatus {
	private String uid;
	private String applicationId;
	private String applicationDate;
	private String status;
	
	
	public MemberStatus() {
		super();
	}
	public MemberStatus(String uid, String applicationId, String applicationDate, String status) {
		super();
		this.uid = uid;
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.status = status;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
