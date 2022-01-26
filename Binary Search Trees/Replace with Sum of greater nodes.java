public class Solution {


	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		if(root==null) return;
        int answer = replaceWithLargerNodesSum(root,0);
	}
    
    public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum){
        if(root==null) return 0;
        
        int right = replaceWithLargerNodesSum(root.right,sum);
        
        int rootdata = root.data;
        
        root.data = root.data + right + sum;
        
        int left = replaceWithLargerNodesSum(root.left,root.data);
        
        return rootdata+ right +left;
        
        
    }
}

/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */
