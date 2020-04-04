package datastructures.arrays;

public class ArrayMultiplication {
	
	/***
	 * Multiplies two large numbers represented as arrays, and returns the product also as an array
	 * @param A
	 * @param B
	 * @return
	 */
	
	private static int[] multiply(int A[], int B[]) {
		
		if(A.length == 0) return B;
		if(B.length == 0) return A;
		
        int resultLength = A.length + B.length;
		int res[] = new int[resultLength];
		
		int carry = 0;
		
		for(int i = B.length -1; i >= 0; i--) {
			for(int j = A.length -1; j >= 0 ; j--) {
				res[i+j+1] = res[i+j+1] + A[j]*B[i];
				res[i+j] = res[i+j] + res[i+j+1] / 10;
				res[i+j+1] = res[i+j+1] % 10;
				
		   }
			ArrayUtil.printArray(res);
			System.out.println();		}
		return res;
		
	}
	
	/**
	 * Multiply two big numbers represented as arrays by adding partial products
	 */
	private static int[] multiplyByPartialProducts(int A[], int B[]) {
		
	    if(A.length == 0) return B;
		if(B.length == 0) return A;
		
		int resultLength = A.length + B.length;
		
		int res[] = new int[resultLength];
		
		int partialProductBeg = A.length + B.length -1;
		
		//Multiply each digit of B with A, and compute partial product
		for(int i = B.length-1; i >= 0; i--) {
			
			int partialProduct[] = new int[A.length + B.length];
			
			int carry = 0;
			int partialProductIndex = partialProductBeg;
			
			for(int j = A.length -1; j >= 0; j--) {
				
				partialProduct[partialProductIndex] = carry + A[j] * B[i];
				carry = partialProduct[partialProductIndex]/10;
				partialProduct[partialProductIndex] = partialProduct[partialProductIndex]%10;
				partialProductIndex--;
				
			}
			partialProduct[partialProductIndex] = carry;
			
			partialProductBeg--;
			
			ArrayUtil.printArray(partialProduct);
			System.out.println();
			
			add(res, partialProduct);
			
		}
		return res;
	}
	
	private static void add(int A[], int B[]) {
		
		int carry = 0;
		
		for (int i= A.length-1; i>=0; i--) {
			
			A[i] = A[i] + B[i] + carry;
			carry = A[i] / 10;
			A[i] = A[i] % 10;
		}
	}
	
	public static void main(String args[]) {
		
		int A[] = {9,9,9};
		int B[] = {9,9};
		
		ArrayUtil.printArray(multiply(A, B));
	}

}
