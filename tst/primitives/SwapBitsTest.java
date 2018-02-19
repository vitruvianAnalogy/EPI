package primitives;

import org.junit.Assert;
import org.junit.Test;

public class SwapBitsTest {
	@Test
	public void testSwapBitsUsingBruteForce(){
		Assert.assertEquals(11, new SwapBits().swapBitsUsingBruteForce(73, 1, 6));
	}
	@Test
	public void testSwapBitsUsingOptimizedBruteForce(){
		Assert.assertEquals(11, new SwapBits().optimizedBruteForce(73, 1, 6));
	}
}
