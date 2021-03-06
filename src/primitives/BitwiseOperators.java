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
	
	/**
	 * O (1) - linear time. This is constant time because we might just go a few levels deep of linear time
	 * in the recursive algorithm, which will in no way is going to be enough to take us to O (n)
	 * 
	 */
	public int addUsingBitwiseOperators(int x, int y){
		
		/**
		 * Generates the carry. For instance 1011 & 0011 -> 0011
		 * 0011 here represents the bits positions which were set in both the numbers.
		 */
		int carry = x & y; 
		
		/**
		 * Let's try to explain what XOR does,
		 * For 1011 ^ 0011 -> 1000. It eliminates any bits that are set in both numbers. These are the bits
		 * that generate the carry, because they are set in both numbers. 
		 * 
		 * If you look closely, you'll notice that x ^ y adds x and y if they don't generate a carry, since
		 * it takes "set" bit from either number to give it to the final number. 
		 */
		x = x ^ y;
		
		/**
		 * If carry is equal to zero, then it means that we can just return the number x ^y since it
		 * represents the sum of x and y considering they don't generate any carry.
		 */
		if(carry == 0){
			return x;
		}
		
		/**
		 * Since whenever a carry is generated, we use it to add to the number to the immediate left, it makes
		 * sense to shift the carry to the left by 1. Since we already calculated the sum of non-carry numbers
		 * using x ^ y, we don't need the value of y anymore.
		 */
		carry = carry << 1;
		
		/**
		 * We need to add this carry to x, which now is x^y, so what we do is, that we add the carry to the x, 
		 * but at the same time we also have to see that more carry doesn't generated, 
		 * If it doesn't get generated, we return the final x, but if it does, we shift it and add it to x again.
		 * At this time it looks like we have a recursive function and therefore it is best to use it.
		 */
		return addUsingBitwiseOperators(x,carry); 
	}
	
	public int multiplyUsingBitwiseOperatorsAndLoopAndDecrements(int x, int y){
		
		int sum = 0;
		while(y>0){
		sum = sum + addUsingBitwiseOperators(sum,x);
		y--;
		}
		
		return sum;
	}
	
	public int multiplyUsingBitwiseOperatorsOnly(int x, int y){
		/**
		 * We know that we cannot use add or any other arithmetic operator.
		 * Increment operators are also banned since they also use arithmetic operators
		 */
		
		int sum = 0;
		//To keep track of bit index of x
		int k = 0;
		
		/**
		 * We need to multiply each bit of x with y
		 * Since each set bit of x in decimal form is 2^k, we need to find a way to multiply y with 2^k
		 * Multiplication of 2^k with y can be done by left shifting y to the left by k bits.
		 * Once we have (2^k)*y, we can use our add method to add them to each other.
		 * 
		 * Considering there are n bits in x, the time complexity of this algo is O (n).
		 * This is because the sum operation is O (1) and the loop runs as long as x > 0, which will
		 * involve shifting through each bit of x
		 */
		while(x>0){
			if((x&1)==1){ //extract the last bit of x, to see if it is 1 or 0
				//O (1) time
				sum = addUsingBitwiseOperators(sum,y<<k); //y<<k represents multiplying y with 2^k 
			}
			x>>=1;
			k++;
		}
		return sum;
	}
	
	public int divideUsingShiftingAdditionAndSubtraction(int x, int y){
		int sum = 0;
		int power = 16; // since we are using int, it is 16 bit in length
		/**
		 * We will shift y by k (here it is 16, because it is an int) which is equivalent to multiplying it by 2^k. 
		 */
		int yPower = y << power; 
		
		/**
		 * We will use this product to find if it is bigger than x or not.
		 */
		while( x >= y){
			/**
			 * while yPower is greater than x, we keep, multiplying it with smaller powers of 2^k
			 */
			while(yPower>x){
				yPower>>>=1;
				--power;
			}
			/** When we reach a state when the product of 2^k with y becomes less than x, 
			 * we subtract 2^k from x and then go back another iteration to re do the steps until
			 * x stays bigger than y.
			 */
			sum += 1L <<power;
			x -= yPower;
		}
		
		return sum;
	}
	
	public double exponentiation(double x, int y){
		double result = 1.0;
		long power = y;
		
		//if y is negative, we reciprocate the number x to 1/x and change y to positive
		if(y<0){
			power = -y;
			x = 1.0/x;
		}
		
		//We will try to do more exponentiation at each multiplication
		while(power!=0){
			/**
			 * If y is even, we can split it into (x^(y/2))^2, if it is odd we can split it like
			 * x * (x^(y/2))^2
			 */
			if((power&1)!=0){ //If odd
				result = result * x;
			}
			x *= x; //We have accomplished x^2, now we need to accomplish y/2
			power >>>=1; //Divide power by 2, so make the power y/2 and repeat the loop
		}
		
		return result;
		
	}

}
