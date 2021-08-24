package com.jobs.domain;

public class Junior extends Employee{
	
	public Junior(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);		
	}
}