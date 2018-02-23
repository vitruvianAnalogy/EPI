package arrays;

public class ArraySnippets {
	public void evenOdd(int[] A){
		int even = 0, odd = A.length-1;
		while (even < odd){
			if(A[even]%2==1){
				int temp = A[even];
				A[even] = A[odd];
				A[odd--] = temp;
				//We won't do even ++ because we don't know whether the term we have swapped with is even or not.
				//Therefore by not incrementing even, we are able to check the same index again and again, until
				//we find an index value that is even so that we can move forward into the array
			} else{
				even++;
			}
		}
	}
}
