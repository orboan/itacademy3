package com.jobs.application;

import java.util.List;

import com.jobs.domain.*;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		this.repository = new EmployeeRepository();
	}
	
	public JobsController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	/* Els següents mètodes
	 * creen empleats que cobren.
	 *
	 * La diferència entre tipus d'empleats
	 * està en el payment rate de cadascun,
	 * essent el payment rate un paràmetre del
	 * constructor d' Employee.
	 * 
	 * Els objectes payment rate són creats
	 * des de la factoria PaymentFactory.
	 * 
	 * Una alternativa a aquest disseny seria
	 * tenir un únic mètode al qual li poguessis
	 * injectar  el payment rate per a establir
	 * el tipus d'empleat, fent ús del polimorfisme
	 * de IPaymentRate.
	 * 
	 */
	
	// ****** Mètodes de creació d'empleats que cobren ******
	
	public void createBossEmployee(String name, String address, String phone, 
			double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, 
				PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, 
			double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, 
				PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, 
			double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, 
				PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}
	// ****** Final de mètodes de creació d'empleats que cobren ******

	
	
	// ****** Mètodes de creació de voluntaris ******
	// amb sobrecàrrega amb i sense descripció explícita
	
	//Voluntari amb descripció per defecte
	public void createVolunteer(String name, String address, String phone)  throws Exception{
		String defaultDescription = "No cobra!";
		Volunteer volunteer = new Volunteer(name, address, phone, defaultDescription);
		repository.addMember(volunteer);
	}
	
	//Voluntari amb descripció explícita
	public void createVolunteer(String name, String address, String phone, 
			String description)  throws Exception{
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);
	}
	// ****** Final de mètodes de creació de voluntaris ******
	
	
	
	public void payAllEmployeers() {
		// TODO Auto-generated method stub
		for(AbsStaffMember member: repository.getAllMembers()) {
			if(member instanceof Employee)
				member.pay();
		}
	
	}

	public String getAllEmployees() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(AbsStaffMember member: repository.getAllMembers()) {
			sb.append(member.toString() + "\n");
		}
		return sb.toString();
	}
	
	
	
}
