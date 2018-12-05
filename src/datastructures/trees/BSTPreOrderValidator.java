package datastructures.trees;

import java.util.Stack;

/**
 * 
 * @author Gurdeep.singh
 * This class has util method to
 * check if a given array of integers can represent the
 * preorder traversal of a Binary Search Tree
 *
 */
public class BSTPreOrderValidator {
    
    /* Brute force method will be, to find, for each element, the next greater element (NGE) on it's right,
     * and then checking if there is any element lesser (after the NGE). If yes, BST property is violated.
     * Same procedure needs to be followed for left and right subtrees.
     * Complexity : O(n^2)
     * Optimized approach : We find NGE of each element in the array using a stack.
     * Whenever NGE of an element(in the stack) is found, it means that we have found 
     * root of the right subtree of that element. This means that no element after this should be less than that element.
     * Complexity : O(n)
     * Following method using optimized approach
     */
    
    public static boolean isValidPreOrder(int A[]) {
        
        int currentRoot = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i =0; i<A.length; i++) {
            if(A[i] < currentRoot) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() < A[i]) {
                currentRoot = stack.pop();
            }
            stack.push(A[i]);
        }
        return true;
    }
    
    public static void main(String args[]) {
        int A[] = {40, 30, 35, 80, 100};
        System.out.println(isValidPreOrder(A));
        int A1[] = {40, 30, 35, 20, 80, 100};
        System.out.println(isValidPreOrder(A1));
        
    }

}
