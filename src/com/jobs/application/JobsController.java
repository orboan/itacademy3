package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Employee;
import com.jobs.domain.Junior;
import com.jobs.domain.Manager;
import com.jobs.domain.Mid;
import com.jobs.domain.Senior;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;

	public JobsController() {
		this.repository = new EmployeeRepository();
	}

	// Sempre és millor injectar el repositori
	public JobsController(EmployeeRepository repository) {
		this.repository = repository;
	}

	/*
	 * Els següents mètodes creen empleats que cobren.
	 *
	 * A nivell 1 Boss i Manager es discriminaven segons el valor de payment rate
	 * 
	 * Ara, a nivell 2, Boss i Manager s'implementen amb classes filles d'Employee a
	 * l'igual que Junior, Mid i Senior.
	 * 
	 * Els objectes payment rate són creats des de la factoria PaymentFactory.
	 * 
	 */

	// ****** Mètodes de creació d'empleats que cobren ******

	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Employee boss = new Boss(name, address, phone, salaryPerMonth, 
					PaymentFactory.createPaymentRateBoss());
			repository.addMember(boss);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Employee employee = new Employee(name, address, phone, salaryPerMonth,
					PaymentFactory.createPaymentRateEmployee());
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Employee manager = new Manager(name, address, phone, salaryPerMonth,
					PaymentFactory.createPaymentRateManager());
			repository.addMember(manager);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createJuniorEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Employee employee = new Junior(name, address, phone, salaryPerMonth,
					PaymentFactory.createPaymentRateJunior());
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createMidEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Employee employee = new Mid(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateMid());
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createSeniorEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			Employee employee = new Senior(name, address, phone, salaryPerMonth,
					PaymentFactory.createPaymentRateSenior());
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ****** Final de mètodes de creació d'empleats que cobren ******

	// ****** Mètodes de creació de voluntaris ******
	// amb sobrecàrrega amb i sense descripció explícita

	// Voluntari amb descripció per defecte
	public void createVolunteer(String name, String address, String phone) {
		String defaultDescription = "No cobra!";
		try {
			Volunteer volunteer = new Volunteer(name, address, phone, defaultDescription);
			repository.addMember(volunteer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Voluntari amb descripció explícita
	public void createVolunteer(String name, String address, String phone, String description) {
		try {
			Volunteer volunteer = new Volunteer(name, address, phone, description);
			repository.addMember(volunteer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Per a testejar la validació que no ha de cobrar
	public void createVolunteer(String name, String address, String phone, 
			double totalPaid) {
		String defaultDescription = "No cobra!";
		try {
			Volunteer volunteer = new Volunteer(name, address, phone, 
					defaultDescription, totalPaid);
			repository.addMember(volunteer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// ****** Final de mètodes de creació de voluntaris ******

	public void payAllEmployeers() {
		// TODO Auto-generated method stub
		for (AbsStaffMember member : repository.getAllMembers()) {
			// if(member instanceof Employee)
			member.pay();
		}

	}

	public String getAllEmployees() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (AbsStaffMember member : repository.getAllMembers()) {
			sb.append(member.toString() + "\n");
		}
		return sb.toString();
	}

}
