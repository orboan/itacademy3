package com.jobs.domain;

public class Senior extends Employee{
	
	public Senior(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);	
		//Màxims i mínim hardcoded
		//es podria guardar al repo igual que hem fet amb els rates
		this.checkSalary(2700,4000);
	}
	
	@Override
	public String toString() {
		String type = "Senior";
		return  type + " " + super.toString();
	}
}
