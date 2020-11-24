package com.cg.model;

public class Policy 
{
	private long policyNumber;
	private long accountNumber;
	private double policyPremium;
	
	
	
	public Policy() {
		super();
	}

	public Policy(long policyNumber, long accountNumber, double policyPremium) {
		super();
		this.policyNumber = policyNumber;
		this.accountNumber = accountNumber;
		this.policyPremium = policyPremium;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}

	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", accountNumber=" + accountNumber + ", policyPremium="
				+ policyPremium + "]";
	}
	
}
