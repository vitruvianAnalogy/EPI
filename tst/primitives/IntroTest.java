package primitives;

import org.junit.Test;
import org.junit.Assert;

public class IntroTest {
	@Test
	public void testNegativeNumber() {
		Assert.assertEquals(31, new Intro().countBits(-3)); //31 since java stores negative numbers as 2's complement
	}
	
	@Test
	public void testPositiveNumber(){
		Assert.assertEquals(2,new Intro().countBits(3));
	}
}
