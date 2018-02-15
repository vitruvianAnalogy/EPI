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
	
}
