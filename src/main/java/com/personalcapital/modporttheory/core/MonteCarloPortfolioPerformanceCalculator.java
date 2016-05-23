package com.personalcapital.modporttheory.core;

import java.util.ArrayList;
import java.util.List;

import com.personalcapital.modporttheory.util.Util;

public class MonteCarloPortfolioPerformanceCalculator implements PortfolioPerformanceCalculator
{
	private Sampler sampler;
	private PercentileCalculator percentileCalculator;
	int iterations;
	
	public MonteCarloPortfolioPerformanceCalculator(Sampler sampler, PercentileCalculator percentileCalculator, int iterations) {
		super();
		this.sampler = sampler;
		this.percentileCalculator = percentileCalculator;
		this.iterations = iterations;
	}

	public  PortfolioResult calculate(double initialPrincipal, int years, double inflationRate){		
		List<Double> data = new ArrayList<Double>();
		for(int i = 1; i <= iterations; i++){
			double adjustedValue = Util.adjsutForInflation(calculateInternal(initialPrincipal, years), inflationRate, 20);			
			data.add(adjustedValue);
			
		}
		
		return new PortfolioResultImpl(data, percentileCalculator);
	}
	
	private double calculateInternal(double initialPrincipal, int years){		
		double finalValue = initialPrincipal;
		for(int i = 1; i <= years; i++){
			double sampleRate = sampler.sample();			
			finalValue = finalValue * (sampleRate/100) + finalValue;
		}
		
		
		return finalValue;
	}
	

	
}
