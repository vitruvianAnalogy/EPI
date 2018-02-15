package primitives;

public class BitwiseOperators {
	
	public int orOperation(int x, int y){return x|y;};
	
	public int andOperation(int x, int y){return x&y;};
	
	//Not operation doesn't work on int
	public boolean notOperation(boolean x){return !x;};
	
	public int xorOperation(int x, int y){return x^y;};

}
