package primitives;

public class Intro {
	
	//Program to count the number of bits set to 1
	//Illustrates shifting and masking
	//How to avoid hard coding the size of the integer word
	//IMPORTANT : For negative numbers it returns the Binary signed 2's complement (it is probably because that is how computers are supposed to store negative numbers)
	public int countBits(int x){
		short numBits = 0;
		while(x!=0){ //If I do a >0 then i fail to check negative numbers.
			numBits += (x&1);
			//If i do right shift here, i would remove the rightmost bit (the bit that we have already tested)
			//If i do left shift here, i'll lose the information (i.e. MSB) that I haven't tested yet
			//Hence i do right shift;
			//Not just right shift, i do logical right shift so that on each right shift, no bit gets added on MSB
			x>>>=1;
		}
		return numBits;
	}

}
