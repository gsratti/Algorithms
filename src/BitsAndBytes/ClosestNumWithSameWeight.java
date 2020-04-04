package BitsAndBytes;

/*
 *  Weight is defined as number of set bits
 *  This class has methods to get the closest, next greatest or previous smallest number which has the same
 *  weight as the given number
 */
public class ClosestNumWithSameWeight {

	public static int GetClosestNumWithSameWeight(int num) { // O(32), or O(word size)

		for(int i = 0; i < 63; i++) {
			if(((num >> i) & 1) != ((num >> (i+1)) &1)) {
				num = num ^ (1 << i | 1 << (i+1) );	
				break;
			}
		}
		return num;
	}

	public static int GetClosestNumWithSameWeight1(int num) { // O(1)

		if(num == 0 || num == 0xFFFFFFF)
		{
			return num;
		}
		
		int set = LowestSetBitSet(num);
		int unSet = LowestUnsetBitSet(num);
		if(set == 1) {
			num = num | unSet;
			num = unSet >> 1 ^ num;
		}
		else {
			num = num ^ set;
			num = num | set >> 1;
		}
		return num;
	}

	private static int LowestSetBitSet(int num) {
		return num & ~(num - 1);
	}

	private static int LowestUnsetBitSet(int num) {
		return ~num & (num + 1);
	}

	public static int GetNextGreatestWithSameWeight(int num) {

		int x = num;

		int trailingZeroes = 0;
		int onesBeforeTralingZeroes = 0;

		while( (x & 1) == 0 && x != 0)
		{
			trailingZeroes++;
			x = x >> 1;
		}

		while ( (x & 1) == 1) {

			onesBeforeTralingZeroes++;
			x = x >> 1;
		}

		if(trailingZeroes + onesBeforeTralingZeroes == 32 || 
				trailingZeroes + onesBeforeTralingZeroes == 0) {
			return -1;
		}

		int p = trailingZeroes + onesBeforeTralingZeroes ; // position of first zero which has 1 to it's right

		num = num | 1 << p;
		num = num & ~(1 << p - 1);
		num = num | ((1 << (onesBeforeTralingZeroes - 1)) -1);

		return num;

	}

	public static void main(String args[]) {

		int num = 8;
		int a = 0xFFFFFFFF;
		System.out.print(a);

        System.out.println(GetNextGreatestWithSameWeight(num));
	    System.out.println(GetClosestNumWithSameWeight1(num));
	}

}
