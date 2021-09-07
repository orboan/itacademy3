package com.jobs.domain;

public class Boss extends Employee{
	public Boss(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);	
		//Màxims i mínim hardcoded
		//es podria guardar al repo igual que hem fet amb els rates
		//-1 indica que no hi ha màxim
		this.checkSalary(8000,-1);
	}
	
	@Override
	public String toString() {
		String type = "Boss";
		return  type + " " + super.toString();
	}
}
