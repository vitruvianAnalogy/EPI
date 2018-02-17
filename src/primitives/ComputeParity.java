package primitives;

public class ComputeParity {
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
}
