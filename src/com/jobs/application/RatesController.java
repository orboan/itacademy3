package com.jobs.application;

import com.jobs.persistence.EmployeeRepository;
import com.jobs.persistence.EmployeeRepository.EmployeeType;

public class RatesController {
	private EmployeeRepository repository;
	
	//Sempre és millor injectar el repositori
	public RatesController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	public void storeBossPaymentRate(float rate) throws Exception{				
		repository.assignRate(EmployeeType.BOSS, rate);
	}	
	
	public void storeManagerPaymentRate(float rate) throws Exception{				
		repository.assignRate(EmployeeType.MANAGER, rate);
	}	
	
	public void storeEmployeePaymentRate(float rate) throws Exception{				
		repository.assignRate(EmployeeType.EMPLOYEE, rate);
	}	
	
	public void storeJuniorPaymentRate(float rate) throws Exception{				
		repository.assignRate(EmployeeType.JUNIOR, rate);
	}	
	
	public void storeMidPaymentRate(float rate) throws Exception{				
		repository.assignRate(EmployeeType.MID, rate);
	}	
	
	public void storeSeniorPaymentRate(float rate) throws Exception{				
		repository.assignRate(EmployeeType.SENIOR, rate);
	}	
}
