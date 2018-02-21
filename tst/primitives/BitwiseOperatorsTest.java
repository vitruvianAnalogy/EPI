package primitives;

import org.junit.Test;
import org.junit.Assert;

public class BitwiseOperatorsTest {

	private BitwiseOperators test = new BitwiseOperators();
	@Test
	public void testOrOperation(){
		Assert.assertEquals(3, test.orOperation(2, 3));
	}
	
	@Test
	public void testAndOperation(){
		Assert.assertEquals(2, test.andOperation(2, 3));
	}
	
	@Test
	public void testNotOperation(){
		
		Assert.assertEquals(new Boolean(true), test.notOperation(false));
	}
	
	@Test
	public void testXorOperation(){
		Assert.assertEquals(1, test.xorOperation(2, 3));
	}
	
	@Test
	public void testIsPowerOf2True(){
		Assert.assertEquals(true, test.isPowerOf2(4));
	}
	
	@Test
	public void testIsPowerOf2False(){
		Assert.assertEquals(false, test.isPowerOf2(5));
	}
	
	@Test
	public void addUsingBitwiseOperatorsTest(){
		Assert.assertEquals(11, test.addUsingBitwiseOperators(2, 9));
	}
	
	@Test
	public void multiplyUsingBitwiseOperatorsOnlyTest(){
		Assert.assertEquals(18, test.multiplyUsingBitwiseOperatorsOnly(3, 6));
	}
}
