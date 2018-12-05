package datastructures.trees;

public class TreeTraverser {
    
    public static void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public static void preOrder(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void postOrder(TreeNode root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void main(String args[]) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(13);
        node.left.left.left = new TreeNode(34);
        node.left.right = new TreeNode(1);
        inOrder(node);
        preOrder(node);
        postOrder(node);
    }
}
