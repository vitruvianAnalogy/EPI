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
	
	public int reverseDigits(int x){
		int reverseX = 0;
		int absX = Math.abs(x);
		while(absX != 0){
			/**
			 * If number is 1 digit long reverseX*10 will be 0, hence returning x%10.
			 * But for longer numbers, every time the loop starts again, we increase the position of the
			 * previous digit by 10 by multiplying it with 10, so 3 becomes 30, 30 becomes 300
			 */
			reverseX = reverseX*10 + absX%10; 
			absX = absX/10;
		}
		
		return x>0?reverseX:-reverseX;
	}

}
