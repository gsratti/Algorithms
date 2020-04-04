package datastructures.arrays;

public class ArrayJumps {

	/***
	 * Given an array in which A[i] represents max index reachable from index i , ie, from 'i' maximum jump
	 * can be to i+A[i]
	 * The method determines if it is possible to reach to last index starting from first
	 * @param A
	 * @return
	 */
	public static boolean possibleToJump(int A[]) {
		
		if (A.length == 0 || A.length == 1)
			return true;
		
		int maxJumpedIndexSoFar = 0; // Max index reached so far by jumping
		
		for(int i = 0; i < A.length; i++) {
			
			if(maxJumpedIndexSoFar == i && A[i] == 0)
				return false;
			maxJumpedIndexSoFar = Math.max(maxJumpedIndexSoFar, A[i]+i);
			
		}
		if(maxJumpedIndexSoFar >= A.length - 1)
			return true;
		return false;
	}
	
	private static int getMinJumps(int A[], int start) {
		
		if(start == A.length - 1)
			return 0;
		
		int minJumps = Integer.MAX_VALUE;
		int currJumps;
		
		for(int i = 1; i <= A[start] && start+i < A.length; i++) {
			
			currJumps = getMinJumps(A, start+i);
			if(currJumps != Integer.MAX_VALUE) {
				minJumps = Math.min(minJumps, currJumps+1);
			}
			
		}
		
		return minJumps;
	}
	
	public static void main(String args[]) {
		
		int A[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		System.out.print(getMinJumps(A,0));
		
		
	
}
}
