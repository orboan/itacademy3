package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

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
				return salaryPerMonth * 1.5;
			}
		};
	}

	public static IPaymentRate createPaymentRateEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * .85;
			}
		};
	}

	public static IPaymentRate createPaymentRateManager() {
		return salari -> salari*1.1;
	}

//	public static IPaymentRate createPaymentRateManager(){
//		return new IPaymentRate() {
//			@Override
//			public double pay(double salaryPerMonth) {
//				return salaryPerMonth*1.1;
//			}
//		};
//	}
}
