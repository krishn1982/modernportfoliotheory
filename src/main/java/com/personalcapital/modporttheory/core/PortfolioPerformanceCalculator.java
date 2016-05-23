package com.personalcapital.modporttheory.core;

public interface PortfolioPerformanceCalculator {
	
	public PortfolioResult calculate(double initialPrincipal, int years, double inflationRate);
	

}
