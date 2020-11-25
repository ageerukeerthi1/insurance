package com.cg.model;

public class Policy 
{
		private Integer policyNumber;
		private double policyPremium;
		private Integer accNumber;
		
		public Policy() {
			super();
		}

		public Policy(Integer policyNumber, double policyPremium, Integer accNumber) {
			super();
			this.policyNumber = policyNumber;
			this.policyPremium = policyPremium;
			this.accNumber = accNumber;
		}

		public Integer getPolicyNumber() {
			return policyNumber;
		}

		public void setPolicyNumber(Integer policyNumber) {
			this.policyNumber = policyNumber;
		}

		public double getPolicyPremium() {
			return policyPremium;
		}

		public void setPolicyPremium(double policyPremium) {
			this.policyPremium = policyPremium;
		}

		public Integer getAccNumber() {
			return accNumber;
		}

		public void setAccNumber(Integer accNumber) {
			this.accNumber = accNumber;
		}

		@Override
		public String toString() {
			return "Policy [policyNumber=" + policyNumber + ", policyPremium=" + policyPremium + ", accNumber=" + accNumber
					+ "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((accNumber == null) ? 0 : accNumber.hashCode());
			result = prime * result + ((policyNumber == null) ? 0 : policyNumber.hashCode());
			long temp;
			temp = Double.doubleToLongBits(policyPremium);
			result = prime * result + (int) (temp ^ (temp >>> 32));
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
			Policy other = (Policy) obj;
			if (accNumber == null) {
				if (other.accNumber != null)
					return false;
			} else if (!accNumber.equals(other.accNumber))
				return false;
			if (policyNumber == null) {
				if (other.policyNumber != null)
					return false;
			} else if (!policyNumber.equals(other.policyNumber))
				return false;
			if (Double.doubleToLongBits(policyPremium) != Double.doubleToLongBits(other.policyPremium))
				return false;
			return true;
		}
		
		
	}