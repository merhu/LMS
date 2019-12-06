package com.lms.entity;

public class Publisher {

	private int publisherId;
	private int publisherPhone; 
	private String publisherName;
	private String publisherAddress;
	
	public Publisher() {
		publisherId=0;
		publisherPhone=0;
		publisherName="";
		publisherAddress="";
		
	}
	public Publisher(int publisherId, int publisherPhone, String publisherName, String publisherAddress) {
		super();
		this.publisherId = publisherId;
		this.publisherPhone = publisherPhone;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public int getPublisherPhone() {
		return publisherPhone;
	}

	public void setPublisherPhone(int publisherPhone) {
		this.publisherPhone = publisherPhone;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	
}
