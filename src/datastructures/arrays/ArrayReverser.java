package datastructures.arrays;

public class ArrayReverser {
    
    public static void reverseArray(int A[])
    {
        int temp;
        for(int i = 0, j = A.length -1; i<j; i++, j--)
        {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        
    }
    
    public static void main(String args[]) {
        
        int A[] = {2,3,4,-9,4,5};
        reverseArray(A);
        for(int i =0 ; i<A.length; i++)
            System.out.print(A[i] + " ");
       
    }

}
