package primitives;

import org.junit.Test;
import org.junit.Assert;

public class ReverseBitsTest {
	
	@Test
	public void testReversedBitsUsingBruteForce(){
		Assert.assertEquals(3, new ReverseBits().usingBruteForce(12));
	}

}
