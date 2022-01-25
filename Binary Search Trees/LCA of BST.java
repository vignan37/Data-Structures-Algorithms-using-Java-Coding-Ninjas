public class Solution {


	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if(root==null) return -1;
        
        if(root.data==a || root.data==b)
            return root.data;
        
        int l = getLCA(root.left,a,b);
        int r = getLCA(root.right,a,b);
        
        if(l==-1 && r==-1) return -1;
        
        else if(l==-1 && r!=-1) return  r;
        
        else if(l!=-1 && r==-1) return l;
        
        else return root.data;
        
	}
}

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */


	
