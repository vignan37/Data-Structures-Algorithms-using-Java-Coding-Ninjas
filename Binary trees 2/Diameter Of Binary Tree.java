/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {
	
    static int diameter =0;
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		height(root);
        return diameter+1;
	}
    
    public static int height(BinaryTreeNode<Integer> root){
        if(root==null) return 0;
        
        int leftH = height(root.left);
        int rightH = height(root.right);
        
        if(leftH+rightH >= diameter){
            diameter = leftH+rightH;
        }
        if(leftH>rightH) return leftH+1;
        else return rightH+1;
    }
	
}
