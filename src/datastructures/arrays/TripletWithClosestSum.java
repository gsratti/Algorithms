package datastructures.arrays;

import java.util.Arrays;

public class TripletWithClosestSum {

	public static int FindClosestSum(int A[], int sum) {

		Arrays.sort(A);
		int l,h;
		int diff = Integer.MAX_VALUE;
		int cSum = 0;

		for(int i = 0; i < A.length - 2; i++) {
			l = i+1;
			h = A.length-1;
			while(l<h) {
				if(Math.abs(sum-A[i]-A[l]-A[h]) < diff) {
					diff = Math.abs(sum-A[i]-A[l]-A[h]);
					cSum = A[i]+A[l]+A[h];
				}
				if(A[i]+A[l]+A[h] < sum) {
					l++;
				}
				else h--;
			}
		}

        return cSum;
	}

}
