package primitives;

public class ClosestWeightInteger {
	/**
	 * To find the closest "equal weight" number, we need to have same number of set bits
	 * Having same number of set bits means if a new bit is set to make the result bigger or smaller than given x
	 * One bit has to be unset to make the weight equal.
	 * And between these two flipped bits, the difference should be minimum.
	 * For the difference to be minimum, we need e.g. k1 and k2, we need 2^k1 - 2^k2 to be the least.
	 * How can this be done? If k1 has to be as small as possible and k2 needs to be very close to it.
	 */
	public int findClosestWeightInteger(int x){
		final int NUM_UNSIGNED_BIT = 63;
		for(int i = 0; i<NUM_UNSIGNED_BIT; i++){
			if(((x>>i) &1)!=((x>>(i+1))&1)){ //If two consecutive bits are not equal
				x ^= (1L <<i) | (1L <<(i+1)); //We swap them.
				return x; //Since we are starting from LSB, therefore, the first such bits encountered will get us the result
			}
		}
		throw new IllegalArgumentException("All bits are 0 or 1");
	}
}
