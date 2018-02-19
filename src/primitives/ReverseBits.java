package primitives;

public class ReverseBits {
	public int usingBruteForce(int x){
		//Convert to string
		String s = Integer.toBinaryString(x);
		s = new String(new StringBuilder(s).reverse());
		//Convert back to int
		return Integer.parseInt(s,2);
	}
}
