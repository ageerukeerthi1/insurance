package com.cg.model;

import java.io.Serializable;

public class Accounts implements Serializable{
	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private Integer insuredZip;
	private String lineOfBusiness;
	private Integer accountNumber;
	
	public Accounts() {
		super();
	}


	public Accounts(String insuredName, String insuredStreet, String insuredCity, String insuredState,
			Integer insuredZip, String lineOfBusiness, Integer accountNumber) {
		super();
		this.insuredName = insuredName;
		this.insuredStreet = insuredStreet;
		this.insuredCity = insuredCity;
		this.insuredState = insuredState;
		this.insuredZip = insuredZip;
		this.lineOfBusiness = lineOfBusiness;
		this.accountNumber = accountNumber;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((insuredCity == null) ? 0 : insuredCity.hashCode());
		result = prime * result + ((insuredName == null) ? 0 : insuredName.hashCode());
		result = prime * result + ((insuredState == null) ? 0 : insuredState.hashCode());
		result = prime * result + ((insuredStreet == null) ? 0 : insuredStreet.hashCode());
		result = prime * result + ((insuredZip == null) ? 0 : insuredZip.hashCode());
		result = prime * result + ((lineOfBusiness == null) ? 0 : lineOfBusiness.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (insuredCity == null) {
			if (other.insuredCity != null)
				return false;
		} else if (!insuredCity.equals(other.insuredCity))
			return false;
		if (insuredName == null) {
			if (other.insuredName != null)
				return false;
		} else if (!insuredName.equals(other.insuredName))
			return false;
		if (insuredState == null) {
			if (other.insuredState != null)
				return false;
		} else if (!insuredState.equals(other.insuredState))
			return false;
		if (insuredStreet == null) {
			if (other.insuredStreet != null)
				return false;
		} else if (!insuredStreet.equals(other.insuredStreet))
			return false;
		if (insuredZip == null) {
			if (other.insuredZip != null)
				return false;
		} else if (!insuredZip.equals(other.insuredZip))
			return false;
		if (lineOfBusiness == null) {
			if (other.lineOfBusiness != null)
				return false;
		} else if (!lineOfBusiness.equals(other.lineOfBusiness))
			return false;
		return true;
	}


	public String getInsuredName() {
		return insuredName;
	}


	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}


	public String getInsuredStreet() {
		return insuredStreet;
	}


	public void setInsuredStreet(String insuredStreet) {
		this.insuredStreet = insuredStreet;
	}


	public String getInsuredCity() {
		return insuredCity;
	}


	public void setInsuredCity(String insuredCity) {
		this.insuredCity = insuredCity;
	}


	public String getInsuredState() {
		return insuredState;
	}


	public void setInsuredState(String insuredState) {
		this.insuredState = insuredState;
	}


	public Integer getInsuredZip() {
		return insuredZip;
	}


	public void setInsuredZip(Integer insuredZip) {
		this.insuredZip = insuredZip;
	}


	public String getLineOfBusiness() {
		return lineOfBusiness;
	}


	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public String toString() {
		return "Accounts [insuredName=" + insuredName + ", insuredStreet=" + insuredStreet + ", insuredCity="
				+ insuredCity + ", insuredState=" + insuredState + ", insuredZip=" + insuredZip + ", lineOfBusiness="
				+ lineOfBusiness + ", accountNumber=" + accountNumber + "]";
	}
	
}


