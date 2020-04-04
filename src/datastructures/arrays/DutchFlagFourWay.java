package datastructures.arrays;

public class DutchFlagFourWay {
	
	/***
	 * Reorders an array of 0s, 1s, 2s and 3s in order of 0s, 1s ,2s and 3s.
	 * @param A
	 */
	private static void reOrder(int A[]) {
		
		int l,e,h;
		l = 0;
		e = 0;
		h = A.length-1;
		
		// First reorder the array into 0s, 1s and (2s and 3s) by 3-way partitioning
		while( e <= h) {
			if(A[e] == 0) {
				ArrayUtil.swap(A, e, l);
				l++;
				e++;
			} else if (A[e] == 1) {
				e++;
			} else {
				ArrayUtil.swap(A, e, h);
				h--;
			}
		}
		
		h = A.length - 1;
		e = A.length - 1;
		
		//Next reorder the last elements of the array into 2s and 3s by 2 way partitioning
		while(e >= 0) {
			if(A[e] == 3) {
				ArrayUtil.swap(A, e, h);
				e--;
				h--;
			} else {
				e--;
			}
		}
	}
	
	public static void main(String args[]) {
		
		int A[] = {2,3,3,2,3,0,0,1,0,2,0,0,1,1,0};
		reOrder(A);
		ArrayUtil.printArray(A);
	}

}
