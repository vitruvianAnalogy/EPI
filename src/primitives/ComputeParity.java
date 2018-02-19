package primitives;

public class ComputeParity {
	
	//This table is empty but we'll assume has all the combination of 16 bit words that we want
	int precomputedParity[] = new int [65536];
	
	public int returnParityUsingBruteForce(int x){
		//return 1 if number of 1's are odd, return 0 if even.
		int sum = 0;
		/**Brute force approach:
		 * Check each bit, and calculate the sum of 1's. In the end find if even or odd.
		 */
		while(x!=0){
			sum = sum + (x&1); //Add the LSB, if 0 then add 0, if 1 then add 1
			x>>>=1; //Logical right shift. Actually arithmetic right shift will also do for negative numbers i guess
		}
		return sum%2==0?0:1;
	}
	
	/**
	 * x & (x-1) results into x losing its lowest set bit
	 */
	public int returnParityUsingOptimization(int x){
		int sum = 0;
		//Instead of testing each bit whether it is on or off, we'll check the lowest set bit, such that
		//we move from set bit to set bit
		
		//We count the number of bits to be 1 so that in case x&(x-1) fails the if, we have already accounted for the bit that they account for. 
		if(x==0)
			return 0;
		else sum++;
		
		while((x=(x&(x-1)))!=0){
			sum++; //Increment the counter every time we clear the lowest set bit. 
			
		}
		return sum%2==0?0:1;
	}
	
	//No test case for this code since we don't have pre-computed cache.
	public int returnParityUsingCaching(int x){
		//We want to cache 2^16 different words, since 2^16 = 65536 is relatively small.
		final int MASK_SIZE = 16;
		//We want to only extract the last 16 bits, since our cached table has 16 bit long word. This bit mask will 
		//help us extract last 16 bits by bit masking
		final int BIT_MASK = 0xFFFF;
		
/**
 * Since we know that we are computing the Parity of 64 bit word (taking into consideration java's number size)
 * we want to divide it into calculating the parity of 4 * 16 bit word. This is partly because we can store 16 bit
 * words in our cache without denting our storage capacity by much. Once this is done, we can make calculating the
 * parity of 16 bit word be a O(1) operation since we have cache that stores all the combinations of the 16 bit word.
 * So rest remains is extracting the four 16 bit blocks. How do we do it? We right shift by 0, 16, 32 and 48. We do bit masking
 * and extract the 0-14, 15-31,32-47,48-63 bits, and then we do XOR.
 */
		return (precomputedParity[(int)((x>>>MASK_SIZE*3)& BIT_MASK)] ^
				precomputedParity[(int)((x>>>MASK_SIZE*2)& BIT_MASK)] ^
				precomputedParity[(int)((x>>>MASK_SIZE*1)& BIT_MASK)] ^
				precomputedParity[(int)(x& BIT_MASK)]);
	}
	
	//Important info: If we use int instead of long, our test case will fail , since x >>> 32 if x is int is returning x.
	//Check https://stackoverflow.com/questions/32648097/java-right-shift-integer-by-32
	/**
	 *Bug: Integer shift by 32 Pattern id: ICAST_BAD_SHIFT_AMOUNT, 
	 *type: BSHIFT, 
	 *category: CORRECTNESS. The code performs an integer shift by a constant amount outside the range 0..31. 
	 *The effect of this is to use the lower 5 bits of the integer value to decide how much to shift by. 
	 *This probably isn't want was expected, and it at least confusing.
	 */
	public int returnParityUsingXOR(long x){
		x ^= (x >>> 32); //Shifts the 1-32 to 33-64 bits and then XOR them with the correct 33-64 bits, making (1-32 bits of no use)
		x ^= (x >>> 16);//Shifts 1-16 bits which ends up shifting 33-48 in place of 48-64 bits and then XORing them with the real 48-64
		x ^= (x >>> 8);
		x ^= (x >>> 4);
		x ^= (x >>> 2);
		x ^= (x >>> 1);
		
		return (int)(x & 0x1); //Since returning x will return the entire all the 64 bits, we only want to return the last bit
		//therefore we masked it with 1, 0x1 represents the hexadecimal equivalent of binary 1.
	}
}
