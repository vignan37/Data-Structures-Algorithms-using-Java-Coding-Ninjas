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
	static int level = 0;
	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
        
        if(root==null) return ;
        
       	changeToDepthTree(root,0);
        
	}
    
    public static void changeToDepthTree(BinaryTreeNode<Integer> root,int level) {
	    //Your code goes here
        
        if(root==null) return ;
        
        root.data = level;
        
        int temp = level;
        
        changeToDepthTree(root.left,++level);
        changeToDepthTree(root.right,++temp);  
	}

}
