package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected String description;
	
	public Volunteer(String name, String address, String phone, 
			String description) throws Exception {
		super(name, address, phone);
		this.description = description;
	}

	
	@Override
	public void pay() {
		totalPaid = 0;		
	}

	@Override
	public String toString() {
		String type = "Vol";

		return  type + "["
				+ super.toString() + ", "
				+ "descripcio=" + this.description + ", "
				+ "totalP: " + this.totalPaid
				+ "]";
	}
}
