package datastructures.arrays;

public class ArrayUtil {
	
   public static void swap(int A[], int i, int j) {
		
		int tmp;
		tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
		
	}
   
   public static void printArray(int A[]) {
	   
	   for (int i = 0; i <A.length; i++) {
		   System.out.print(A[i] + " ");
	   }
   }

}
