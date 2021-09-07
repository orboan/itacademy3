package com.jobs.application;

import java.util.Map;

import com.jobs.domain.IPaymentRate;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.persistence.EmployeeRepository.EmployeeType;

public class PaymentFactory {

	private static Map<EmployeeType, Double> rates = 
			(new EmployeeRepository()).getRates();
	
	/*
	 * Els següents mètodes retornen una implementació de la interfície
	 * IPaymentRate.
	 * 
	 * En ser IPaymentRate una interfície funcional podríem 
	 * refactoritzar aquests mètodes usant lambdes.
	 */

	public static IPaymentRate createPaymentRateBoss() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * rates.get(EmployeeType.BOSS);
			}
		};
	}

	public static IPaymentRate createPaymentRateEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * rates.get(EmployeeType.EMPLOYEE);
			}
		};
	}

	public static IPaymentRate createPaymentRateManager() {
		return salari -> salari * rates.get(EmployeeType.MANAGER);
	}

//	public static IPaymentRate createPaymentRateManager(){
//		return new IPaymentRate() {
//			@Override
//			public double pay(double salaryPerMonth) {
//				return salaryPerMonth*1.1;
//			}
//		};
//	}
	
	//Juniors tenen una reducció del 15%
	public static IPaymentRate createPaymentRateJunior() {
		return salari -> salari * rates.get(EmployeeType.JUNIOR);
	}
	
	//Mids tenen una reducció del 10%
	public static IPaymentRate createPaymentRateMid() {
		return salari -> salari * rates.get(EmployeeType.MID);
	}

	//Seniors tenen una reducció del 5%
	public static IPaymentRate createPaymentRateSenior() {
		return salari -> salari * rates.get(EmployeeType.SENIOR);
	}
	
}
