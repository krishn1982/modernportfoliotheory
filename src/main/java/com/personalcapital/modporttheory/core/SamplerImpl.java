package com.personalcapital.modporttheory.core;

import org.apache.commons.math3.distribution.NormalDistribution;

public class SamplerImpl implements Sampler {
	
	private NormalDistribution nb ;

	public SamplerImpl(double mean, double sd) {
		super();
		nb = new NormalDistribution(mean, sd);
	}


	public double sample() {
		return nb.sample();
	}

}
