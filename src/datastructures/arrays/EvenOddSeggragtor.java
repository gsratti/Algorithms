package datastructures.arrays;

public class EvenOddSeggragtor {
	
	/**
	 * Seggregate even and odd integers
	 * @param A
	 */
	
	public static void BringEvenForward(int A[]) {
		
		int evenPos = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] % 2 == 0) {
				ArrayUtil.swap(A,i,evenPos);
				evenPos++;
			}
		}
	}
	
	public static void main(String args[]) {
		
		int A[] = {3,4,1,1,6,8,8,9,0,11,21,12};
		BringEvenForward(A);
		
		for(int i = 0; i < A.length; i++) {
		System.out.print(A[i] + " ");
		}
		
	}

}
