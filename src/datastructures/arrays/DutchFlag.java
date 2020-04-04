package datastructures.arrays;

public class DutchFlag {
	
	public static void reOrder(int A[], int pivot) {
		
		int small,equal,large;
		
		small = equal = 0;
		large = A.length - 1;
		
		while(equal < large) {
			
			if(A[equal] < pivot) {
				ArrayUtil.swap(A, equal, small);
				equal ++;
				small ++;
			} 
			else if (A[equal] == pivot) {
				equal ++;
			}
			else {
				ArrayUtil.swap(A, equal, large);
				equal++;
				large --;
			}
		}
	 }
	
	public static void main(String args[]) {
		
		int A[] = {3,2,3,-1,10,3,11};
		reOrder(A,3);
		ArrayUtil.printArray(A);
	}

}
