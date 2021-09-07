package com.jobs.domain;

public class Mid extends Employee{
	
	public Mid(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);	
		//Màxims i mínim hardcoded
		//es podria guardar al repo igual que hem fet amb els rates
		this.checkSalary(1800,2500);
	}
	
	@Override
	public String toString() {
		String type = "Mid";
		return  type + " " + super.toString();
	}
}
