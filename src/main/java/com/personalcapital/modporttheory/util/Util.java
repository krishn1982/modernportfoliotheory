package com.personalcapital.modporttheory.util;

public class Util {
	
	public static double adjsutForInflation(double amount, double rate, double years){
		double val = (rate/100) + 1;
		return (amount)/(Math.pow(val, years));		
		
	}

}
