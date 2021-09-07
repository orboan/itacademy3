package com.jobs.domain;

public class Manager extends Employee{
	
	public Manager(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);	
		//Màxims i mínim hardcoded
		//es podria guardar al repo igual que hem fet amb els rates
		this.checkSalary(3000,5000);
	}
	
	@Override
	public String toString() {
		String type = "Manager";
		return  type + " " + super.toString();
	}
}
