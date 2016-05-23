package modernportfoliotheory;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.personalcapital.modporttheory.core.MonteCarloPortfolioPerformanceCalculator;
import com.personalcapital.modporttheory.core.PercentileCalculator;
import com.personalcapital.modporttheory.core.PercentileCalculatorImpl;
import com.personalcapital.modporttheory.core.PortfolioResult;
import com.personalcapital.modporttheory.core.Sampler;

public class MonteCarloPortfolioPerformanceCalculatorTest {
	private static final int ITERATIONS = 10;
	private static final double PRINCIPAL_AMOUNT = 100;
	private static final int YEARS = 20;
	private static final double INFLATION_RATE = 3.5;
	private Sampler mockSampler;
	private PercentileCalculator percentileCalculator;
	
	private  MonteCarloPortfolioPerformanceCalculator testObj;
	
	@Before
    public void setUp() {
		mockSampler = Mockito.mock(Sampler.class);
		percentileCalculator = new PercentileCalculatorImpl();
		testObj = new MonteCarloPortfolioPerformanceCalculator(mockSampler, percentileCalculator, ITERATIONS);
    }

	@Test
	public void test_calculate_when_sampler_always_choses_rate_equivalent_to_inflationRate() {
		 when(mockSampler.sample()).thenReturn(INFLATION_RATE);
		 PortfolioResult result = testObj.calculate(PRINCIPAL_AMOUNT, YEARS, INFLATION_RATE);
		 Assert.assertEquals(100.0, result.getMedianValue(), 0.1);
		 Assert.assertEquals(100.0, result.getBestTenPercentValue(), 0.1);
		 Assert.assertEquals(100.0, result.getWorstTenPercentValue(), 0.1);
		
	}

}
