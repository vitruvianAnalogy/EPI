package primitives;

import org.junit.Test;
import org.junit.Assert;

public class SnippetsTest {
	
	@Test
	public void testClearingLowestBit(){
		Snippets s = new Snippets();
		Assert.assertEquals(32, s.clearLowestSetBit(48));
	}
	
	@Test
	public void testPositiveReverseDigits(){
		Snippets s = new Snippets();
		Assert.assertEquals(184, s.reverseDigits(481));
	}
	
	@Test
	public void testNegativeReverseDigits(){
		Snippets s = new Snippets();
		Assert.assertEquals(-184, s.reverseDigits(-481));
	}

}
