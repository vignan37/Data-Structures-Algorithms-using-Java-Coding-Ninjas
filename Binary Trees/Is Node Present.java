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
	
   static  boolean present=false;
    
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    if(root==null) return false;
        
         isNodePresenti(root,x);
        return present;
        
    }
    
    
    
    public static void isNodePresenti(BinaryTreeNode<Integer> root, int x) {
	    if(root==null) return;
        
        if(root.data == x) present = true;
        
        isNodePresenti(root.left,x);
        isNodePresenti(root.right,x);
	}

}
