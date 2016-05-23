package com.personalcapital.modporttheory.core;

public class Runner {
	private static final int ITERATIONS = 10000;
	private static final double PRINCIPAL_AMOUNT = 100000;
	private static final int YEARS = 20;
	private static final double AGGRESSIVE_SD = 15.675;
	private static final double AGGRESSIVE_MEAN = 9.4324;
	private static final double CONSERVATIVE_SD =6.3438;
	private static final double CONSERVATIVE_MEAN = 6.189;
	private static final double INFLATION_RATE = 3.5;

	public static void main(String [] args){
		
		Sampler aggresiveSampler = new SamplerImpl(AGGRESSIVE_MEAN, AGGRESSIVE_SD);
		Sampler conservativeSampler = new SamplerImpl(CONSERVATIVE_MEAN, CONSERVATIVE_SD);
		PercentileCalculator percentileCalculator = new PercentileCalculatorImpl();
		
		MonteCarloPortfolioPerformanceCalculator aggresiveCalculator = new MonteCarloPortfolioPerformanceCalculator(aggresiveSampler, percentileCalculator, ITERATIONS);
		MonteCarloPortfolioPerformanceCalculator conservativeCalculator = new MonteCarloPortfolioPerformanceCalculator(conservativeSampler, percentileCalculator, ITERATIONS);
		PortfolioResult aggresivePortfolioResult = aggresiveCalculator.calculate(PRINCIPAL_AMOUNT, YEARS, INFLATION_RATE);
		PortfolioResult conservativePortfolioResult = conservativeCalculator.calculate(PRINCIPAL_AMOUNT, YEARS, INFLATION_RATE);
		
		System.out.println("agressive median valus is "+ aggresivePortfolioResult.getMedianValue());		
		System.out.println("agressive 90%ile valus is "+ aggresivePortfolioResult.getBestTenPercentValue());
		System.out.println("agressive 10%ile valus is "+ aggresivePortfolioResult.getWorstTenPercentValue());
		System.out.println("conservative median valus is "+ conservativePortfolioResult.getMedianValue());
		System.out.println("conservative 90%ile valus is "+ conservativePortfolioResult.getBestTenPercentValue());		
		System.out.println("conservative 10%ile valus is "+ conservativePortfolioResult.getWorstTenPercentValue());
	}

}
