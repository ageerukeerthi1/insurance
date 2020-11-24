package com.cg.model;

public class Insured {
	private long accountNumber;
	private String insuredName;
	private String street;
	private String city;
	private String state;
	private int zip;
	private String businessSegment;
	private String userName;
	
	
	public Insured(String insuredName, String street, String city, String state, int zip, String businessSegment,
			String userName) {
		super();
		this.insuredName = insuredName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.businessSegment = businessSegment;
		this.userName = userName;
	}
	public Insured() {
		super();
	}
	public Insured(long accountNumber, String insuredName, String street, String city, String state, int zip,
			String businessSegment, String userName) {
		super();
		this.accountNumber = accountNumber;
		this.insuredName = insuredName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.businessSegment = businessSegment;
		this.userName = userName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getBusinessSegment() {
		return businessSegment;
	}
	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "InsuredDTO [accountNumber=" + accountNumber + ", insuredName=" + insuredName + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", businessSegment=" + businessSegment
				+ ", userName=" + userName + "]";
	}
	

}
