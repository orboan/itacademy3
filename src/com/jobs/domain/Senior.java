package com.jobs.domain;

public class Senior extends Employee{
	
	public Senior(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate,
			IPaymentIrpf paymentIrpf) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate, paymentIrpf);	

		//Ho movem al controlador, on té més sentit 
		//posar-hi regles de negoci
//		this.checkSalary(2700,4000);
	}
	
	@Override
	public String toString() {
		String type = "Senior";
		return  type + " " + super.toString();
	}
}
