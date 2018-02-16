package primitives;

import org.junit.Test;
import org.junit.Assert;

public class SnippetsTest {
	
	@Test
	public void testClearingLowestBit(){
		Snippets s = new Snippets();
		Assert.assertEquals(32, s.clearLowestSetBit(48));
	}

}
