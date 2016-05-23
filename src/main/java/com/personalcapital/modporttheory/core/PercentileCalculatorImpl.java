package com.personalcapital.modporttheory.core;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

public class PercentileCalculatorImpl implements PercentileCalculator {

	private Percentile percentileCalc;

	public PercentileCalculatorImpl() {
		super();
		percentileCalc = new Percentile();
		
	}

	public double calculate(double p, List<Double> data) {
		percentileCalc.setData(ArrayUtils.toPrimitive(data.toArray(new Double[0])));
		return percentileCalc.evaluate(p);
	}

}
