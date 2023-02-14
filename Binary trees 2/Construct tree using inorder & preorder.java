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

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
		return buildTree(preOrder,inOrder,0,preOrder.length-1);
        
    	}
    
    static int preIndex = 0;
    
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder, int is, int ie) {
		
        if(is>ie) return null;
		
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder[preIndex++]);
        
        int inIndex = 0;
        
        for(int i=is;i<=ie;i++){
            if(inOrder[i]== root.data){
                inIndex = i;
                break;
            }
        }
        
        root.left = buildTree(preOrder,inOrder,is,inIndex-1);
        root.right = buildTree(preOrder,inOrder,inIndex+1,ie);
        return root;
        
    	}

}
