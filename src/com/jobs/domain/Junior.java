package com.jobs.domain;

public class Junior extends Employee{
	
	public Junior(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);	
		//Màxims i mínim hardcoded
		//es podria guardar al repo igual que hem fet amb els rates
		this.checkSalary(900,1600);
	}
	
	@Override
	public String toString() {
		String type = "Junior";
		return  type + " " + super.toString();
	}
}