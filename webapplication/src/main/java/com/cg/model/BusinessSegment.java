package com.cg.model;

public class BusinessSegment {
	private String Bus_Seg_Id;
	private Integer Bus_Seg_Seq;
	private String Bus_Seg_Name;
	
	
	
	public BusinessSegment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BusinessSegment(String bus_Seg_Id, Integer bus_Seg_Seq, String bus_Seg_Name) {
		super();
		Bus_Seg_Id = bus_Seg_Id;
		Bus_Seg_Seq = bus_Seg_Seq;
		Bus_Seg_Name = bus_Seg_Name;
	}



	public String getBus_Seg_Id() {
		return Bus_Seg_Id;
	}



	public void setBus_Seg_Id(String bus_Seg_Id) {
		Bus_Seg_Id = bus_Seg_Id;
	}



	public Integer getBus_Seg_Seq() {
		return Bus_Seg_Seq;
	}



	public void setBus_Seg_Seq(Integer bus_Seg_Seq) {
		Bus_Seg_Seq = bus_Seg_Seq;
	}



	public String getBus_Seg_Name() {
		return Bus_Seg_Name;
	}



	public void setBus_Seg_Name(String bus_Seg_Name) {
		Bus_Seg_Name = bus_Seg_Name;
	}



	@Override
	public String toString() {
		return "BusinessSegment [Bus_Seg_Id=" + Bus_Seg_Id + ", Bus_Seg_Seq=" + Bus_Seg_Seq + ", Bus_Seg_Name="
				+ Bus_Seg_Name + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Bus_Seg_Id == null) ? 0 : Bus_Seg_Id.hashCode());
		result = prime * result + ((Bus_Seg_Name == null) ? 0 : Bus_Seg_Name.hashCode());
		result = prime * result + ((Bus_Seg_Seq == null) ? 0 : Bus_Seg_Seq.hashCode());
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
		BusinessSegment other = (BusinessSegment) obj;
		if (Bus_Seg_Id == null) {
			if (other.Bus_Seg_Id != null)
				return false;
		} else if (!Bus_Seg_Id.equals(other.Bus_Seg_Id))
			return false;
		if (Bus_Seg_Name == null) {
			if (other.Bus_Seg_Name != null)
				return false;
		} else if (!Bus_Seg_Name.equals(other.Bus_Seg_Name))
			return false;
		if (Bus_Seg_Seq == null) {
			if (other.Bus_Seg_Seq != null)
				return false;
		} else if (!Bus_Seg_Seq.equals(other.Bus_Seg_Seq))
			return false;
		return true;
	}
	
	
	
	

}

