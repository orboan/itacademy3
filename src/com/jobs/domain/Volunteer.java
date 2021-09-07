package com.jobs.domain;

public class Volunteer extends AbsStaffMember {

	protected String description;

	public Volunteer(String name, String address, String phone, 
			String description) throws Exception {
		super(name, address, phone);
		this.description = description;
		/*
		 * Es valida que un voluntari no cobri
		 * 
		 * En aquest cas, sempre validarà ja
		 * que el camp totalPaid té valor per defecte 0
		 * i no hi ha cap mutator que el modifiqui,
		 * ni es pot assignar en el constructor
		 * que tenim.
		 * 
		 */
		checkSalary();
	}
	
	//Sobrecàrrega del constructor amb totalPay
	//per a poder testejar la validació
	public Volunteer(String name, String address, String phone, 
			String description, double totalPaid) throws Exception {
		super(name, address, phone);
		this.description = description;
		this.totalPaid = totalPaid;
		checkSalary();
	}

	@Override
	public void pay() {
		
		/* 
		 * Com que el voluntari 
		 * no cobra, pay() no canvia
		 * el valor per defecte
		 * de totalPaid, que és 0
		 */
		totalPaid = 0.0;
	}

	//Controla que el salari pagat al voluntari sigui 0
	public void checkSalary() throws Exception {
		this.checkSalary(0.0,this.totalPaid);
	}
	
	@Override
	public void checkSalary(double minSal, double maxSal)
			throws Exception {
			if (minSal != 0 || maxSal != 0)
				throw new Exception("Voluntaris no cobren!");
	}
	

	@Override
	public String toString() {
		String type = "Vol";

		return type + "[" + super.toString() + ", " + "descripcio=" + this.description + ", " + "totalP: "
				+ this.totalPaid + "]";
	}
}
