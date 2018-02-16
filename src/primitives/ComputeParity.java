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
	
	public int returnParityUsingOptimization(int x){
		return 1;
	}
}
