package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@SuppressWarnings("unused")
	public static void main (String[] args){
		//How to allocate new array
		int[] newArray = new int[]{1,2,3};
		int[] newArray2 = new int[32];
		
		//How to instantiate a 2D array
		int[][] twoDArray = new int[2][2];
		
		int[][] twoDArray2 = new int[3][];
		twoDArray2[1] = new int [2];
		twoDArray2[2] = new int [3];
		twoDArray2[0] = new int [5];
		
		//How to get length
		int numberOfRows = twoDArray2.length;
		int lengthOfColumnsInFirstRow = twoDArray2[0].length;
		
		String testString = "Nishant";
		testString.length(); // length is a method in string and a property in array
		
		ArrayList newArrayList = new ArrayList();
		newArrayList.size(); //length in arraylist is accessed by size method
		
		/**
		 * 'Arrays' class have a lot of static utility methods
		 */
		
		List<Integer> t = Arrays.asList(1,2,3); //Create a list
		
		int[] testArray = {1,2,3};
		int x = Arrays.binarySearch(testArray, 2); //Do binary search on an array
		int[] copyOfTestArrayWithLength5 = Arrays.copyOf(testArray, 5);
		
		Arrays.fill(testArray, 3); //fill testArray with 3
		Arrays.equals(testArray, copyOfTestArrayWithLength5); //testing if these two arrays are equal
		
		int y = Arrays.hashCode(testArray); //returns hashcode based on the contents of the array
		Arrays.sort(testArray); //sorts the array into ascending order
		Arrays.toString(testArray); //returns string representation of the entire array
		
	}
}
