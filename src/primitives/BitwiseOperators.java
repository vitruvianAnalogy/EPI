package primitives;

public class BitwiseOperators {
	
	public int orOperation(int x, int y){return x|y;};
	
	public int andOperation(int x, int y){return x&y;};
	
	//Not operation doesn't work on int
	public boolean notOperation(boolean x){return !x;};
	
	public int xorOperation(int x, int y){return x^y;};
	
	//01010000 becomes 01011111
	public int rightPropogateRightmostSetBit(int x){
		return x | (x-1);
	};
	
	public int computeXModPower2(int x, int a){
		return x ^ a;
	}
	
	public boolean isPowerOf2(int x){
		//only one bit should be set
		int a = x & (x-1); //zero out bits at lowest set and after it.
		 //if after removing the lowest set bit and the bits after it the number is still not zero, then there
		//must have been more than 1 set bit.
		if (a!=0)
			return false;
		else
			return true;
	}

}
