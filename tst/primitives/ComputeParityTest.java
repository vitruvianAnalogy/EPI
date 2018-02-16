package primitives;

import org.junit.Assert;
import org.junit.Test;

public class ComputeParityTest {
	
	@Test
	public void testOddParityUsingBruteForce(){
		Assert.assertEquals(1, new ComputeParity().returnParityUsingBruteForce(1));
	}
	
	@Test
	public void testEvenParityUsingBruteForce(){
		Assert.assertEquals(0, new ComputeParity().returnParityUsingBruteForce(3));
	}
	
	@Test
	public void testEvenParityUsingBruteForceForNegativeNumber(){
		Assert.assertEquals(1, new ComputeParity().returnParityUsingBruteForce(-3)); //-3 is 1111111111111101
	}

}