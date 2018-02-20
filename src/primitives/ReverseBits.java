package primitives;

public class ReverseBits {
	public int usingBruteForce(int x){
		//Convert to string
		String s = Integer.toBinaryString(x);
		s = new String(new StringBuilder(s).reverse());
		//Convert back to int
		return Integer.parseInt(s,2);
	}
	
	public int usingSwaps(int x){
		//TODO
		SwapBits s = new SwapBits();
		for(int i=0;i<=31;i++){
			x = s.optimizedBruteForce(x, 31-i, i);
		}
		return x;
	}
}
