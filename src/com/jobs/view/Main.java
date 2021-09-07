package com.jobs.view;

import com.jobs.application.JobsController;
import com.jobs.application.RatesController;
import com.jobs.persistence.EmployeeRepository;

public class Main {

	private static EmployeeRepository repo;
	
	static {
		repo = new EmployeeRepository();
	}
		
	// private static JobsController controller=new JobsController();
	//És millor injectar el repository (DI)
	//així és més fàcil adaptar el codi al canvi de repo
	private static JobsController controller = 
			new JobsController(repo);
	
	private static RatesController ratesController =
			new RatesController(repo);

	public static void main(String[] args) throws Exception {

		//Abans de crear els empleats, assignem a cada
		//tipus d'empleat el seu payment rate
		ratesController.storeBossPaymentRate(1.5f);
		ratesController.storeManagerPaymentRate(1.1f);
		ratesController.storeEmployeePaymentRate(0.85f);
		ratesController.storeJuniorPaymentRate(0.85f);
		ratesController.storeMidPaymentRate(0.9f);
		ratesController.storeSeniorPaymentRate(0.95f);
		
		//(de la mateixa manera podríem guardar al repositori
		//els valors màxims i mínims de sous nets que ha
		//de cobrar cada tipus d'empleat).
		
		
		//nivell 2
		//Creació d'instàncies amb valors correctes de sous nets
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 8100.0);
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 4490.0);
		controller.createJuniorEmployee("Jordi Junior", "Adreça acollonant", "333333333", 1200.0);
		controller.createMidEmployee("Mateu Mid", "Adreça acollonant 2", "111111111", 2100.0);
		controller.createSeniorEmployee("Sergi Senior", "Adreça acollonant 3", "444444444", 3900.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		
		//Creació d'instàncies amb valors incorrectes de sous nets
		controller.createBossEmployee("Claudia Boss", "Adreça flipant", "666666666", 3500.0);
		controller.createManagerEmployee("Leyla Manager", "Dirección molona 2", "665226666", 6000.0);
		controller.createJuniorEmployee("Pepet Junior", "Adreça acollonant", "333333333", 700.0);
		controller.createMidEmployee("Popeye Mid", "Adreça acollonant 2", "111111111", 1500.0);
		controller.createSeniorEmployee("Quimet Senior", "Adreça acollonant 3", "444444444", 9000.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666", 10);
		
		
		controller.payAllEmployeers();

		String allEmployees = controller.getAllEmployees();

		System.out.println("EMPLOYEES: \n" + allEmployees + " \n");

	}

}
