package primitives;

public class SwapBits {
	public int swapBitsUsingBruteForce(int x, int i, int j){
		String t = Integer.toBinaryString(x);
		char ith = t.charAt(i);
		char jth = t.charAt(j);
		if (ith==jth)
			return x;
		else if(ith>jth) {
			t=t.substring(0, j)+ith+t.substring(j+1, i)+jth+t.substring(i+1);
		}
		else{
			t=t.substring(0, i)+jth+t.substring(i+1, j)+ith+t.substring(j+1);
		}
		StringBuilder t1 = new StringBuilder(t);
		t = new String(t1.reverse());
		return Integer.parseInt(t, 2);
	}
}
