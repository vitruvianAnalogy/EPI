package primitives;

public class Snippets {
	
	//Basically convert lowest most 1 to 0. We do bit masking like that with AND (with 0) operation.
	public int clearLowestSetBit(int x){
		//	bits&= (bits -1) without knowing the index
		int xMinus1 = x -1;  // 100000 - 1 becomes 011111
		return (xMinus1 & x);
	}
	
	public int getIndexOfLowestSetBit(int x){
		return -1;
	}

}
