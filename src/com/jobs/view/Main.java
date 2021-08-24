package com.jobs.view;

import com.jobs.application.JobsController;
import com.jobs.persistence.EmployeeRepository;

public class Main {

	// private static JobsController controller=new JobsController();
	//És millor injectar el repository (DI)
	//així és més fàcil adaptar el codi al canvi de repo
	private static JobsController controller = 
			new JobsController(new EmployeeRepository());

	public static void main(String[] args) throws Exception {

		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 80.0);

		controller.payAllEmployeers();

		String allEmployees = controller.getAllEmployees();

		System.out.println("EMPLOYEES: \n" + allEmployees + " \n");

	}

}
