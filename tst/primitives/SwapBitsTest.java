package primitives;

import org.junit.Assert;
import org.junit.Test;

public class SwapBitsTest {
	@Test
	public void testSwapBits(){
		Assert.assertEquals(11, new SwapBits().swapBitsUsingBruteForce(73, 1, 6));
	}
}
