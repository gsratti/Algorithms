package BitsAndBytes;

public class SpecificBitsSwapper {
	
	public static int swapBits(int num, int i , int j) {
		
		if( num == 0 || num == 0xFFFFFFFF || i == j) {
			return num;
		}
		
		int iBit = num >> i & 1;
		int jBit = num >> j & 1;
		
		if( iBit != jBit ) {
			if( iBit == 1) {
				num = num & ~(1 << iBit);
				num = num | ( 1 << jBit);
			}
			else {
				num = num | (1 << iBit);
				num = num & ~( 1 << jBit);
			}
		}
		return num;
	}
	
	public static int swapBits1(int num, int i, int j) {
		
		if( num == 0 || num == 0xFFFF || i == j) {
			return num;
		}
		
		int iBit = num >> i & 1;
		int jBit = num >> j & 1;
	   
	   if(iBit != jBit) {
		   int mask = 1 << iBit | 1 << jBit; // xor is 1, form mask with xor at ith and jth pos
		   num = num ^ mask;
	   }
		
	   return num;
	}
	
	public static void main(String agrs[]) {
		
		int a = 2;
		a = swapBits1(a, 0, 1);
		System.out.println("After swapping bits, number = " + a);
	}
}
