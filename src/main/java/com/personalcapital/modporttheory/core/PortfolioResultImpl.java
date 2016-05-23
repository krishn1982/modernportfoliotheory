package com.personalcapital.modporttheory.core;

import java.util.List;

public class PortfolioResultImpl implements PortfolioResult {
	private final List<Double> data;
	private final PercentileCalculator percentileCalculator;

	public PortfolioResultImpl(List<Double> data, PercentileCalculator percentileCalculator) {
		super();
		this.data = data;
		this.percentileCalculator = percentileCalculator;
	}

	public double getMedianValue() {
		return percentileCalculator.calculate(50, this.data);
		
	}

	public double getBestTenPercentValue() {
		return percentileCalculator.calculate(90, this.data);
	}

	public double getWorstTenPercentValue() {
		return percentileCalculator.calculate(10, this.data);
	}

}
