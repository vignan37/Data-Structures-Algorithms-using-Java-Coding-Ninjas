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
	//static int result =0;
	
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here
        if(root==null) return 0;
        
         //traverse(root, x);
        
        int result = (root.data>x)? 1:0;
        
        if(root.left!=null){
            result += countNodesGreaterThanX(root.left,x);
        }
        
        if(root.right!=null){
            result += countNodesGreaterThanX(root.right,x);
        }
        
        
        return result;
        
	}

}
