package com.jobs.domain;


public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;

	public Employee(String name, String address, String phone, 
			double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone);
		if (salaryPerMonth < 0)
			throw new Exception("Error: No podem assignar un salari negatiu.");
		if (paymentRate == null)
			throw new Exception("Error: paymentRate no pot ser null");

		this.salaryPerMonth = salaryPerMonth;
		this.paymentRate = paymentRate;
	}

	@Override
	public void pay() {
		totalPaid = paymentRate.pay(salaryPerMonth);
	}

	@Override
	public void checkSalary(double minSal, double maxSal) throws Exception {
		double totalPaid = paymentRate.pay(salaryPerMonth);
		String totalPaidStr = String.format("TotalPaid = %.2f",totalPaid);
		// paymentRate no pot ser null, segons constructor
		if (totalPaid <= minSal)
			throw new Exception("L'empleat " + this.name + " cobra massa poc! (" + totalPaidStr + "). Ha de cobrar més de " + minSal);
		if (maxSal != -1 && totalPaid >= maxSal)
			throw new Exception("L'empleat " + this.name + " cobra massa! (" + totalPaidStr + "). Ha de cobrar menys de " + maxSal);

	}

	@Override
	public String toString() {
		String type = "Emp";
		String totalPayStr = String.format("%.2f",this.totalPaid);

		return type + "[" + super.toString() + ", " + "salaryPerMonth=" + this.salaryPerMonth + ", " + "totalP: "
				+ totalPayStr + "]";
	}

}
