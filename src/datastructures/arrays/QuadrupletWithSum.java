package datastructures.arrays;

import java.util.Arrays;
import java.util.Comparator;

class Pair {
	int sum;
	int i,j;
	public Pair(int i, int j) {
		this.i = i;
		this .j = j;
	}
}

public class QuadrupletWithSum {
	
	
	public static void getQuadrupletsWithSum(int A[], int sum) {
		
		int n = A.length;
		Pair[] pairs = new Pair[n*(n-1)/2];
		int k =0;
		
		for(int i=0; i<A.length; i++) {
			for(int j = i+1; j<A.length; j++) {
				Pair p = new Pair(i,j);
				p.sum = A[i]+A[j];
				pairs[k++] = p;
			}
		}
		
		Arrays.sort(pairs, new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				return a.sum-b.sum;
			}
		});
	}

}
