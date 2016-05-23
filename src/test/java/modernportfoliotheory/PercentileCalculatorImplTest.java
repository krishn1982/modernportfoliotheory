package modernportfoliotheory;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.personalcapital.modporttheory.core.PercentileCalculatorImpl;

import org.junit.Assert;

public class PercentileCalculatorImplTest {
	
	PercentileCalculatorImpl testObj;
	
	@Before
    public void setUp() {
		testObj = new PercentileCalculatorImpl();
    }


	
	@Test
	public void test_calculate_50th_percentile_when_odd_population() {
		List<Double> data = new  ArrayList<Double>();		
		data.add(5.0);
		data.add(2.0);
		data.add(4.0);
		data.add(7.0);
		data.add(8.0);
		
		Assert.assertEquals(5.0, testObj.calculate(50, data),0.0);
	}
	
	@Test
	public void test_calculate_50th_percentile_when_even_population() {
		List<Double> data = new  ArrayList<Double>();		
		data.add(5.0);
		data.add(2.0);
		data.add(4.0);
		data.add(7.0);
		data.add(8.0);
		data.add(9.0);
		
		Assert.assertEquals(6.0, testObj.calculate(50, data),0.0);
	}
		
	
	
}
