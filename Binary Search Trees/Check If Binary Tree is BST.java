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
import java.util.*;

public class Solution {
	
    public static boolean isBST(BinaryTreeNode<Integer> root){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isBST(root,min,max);
    }
	
    
    public static boolean isBST(BinaryTreeNode<Integer> root, int min,int max) {
		
        if(root == null) return true;
        
           if (root.data < min || root.data > max)
            return false;
 
         return (isBST(root.left, min, root.data) &&
                isBST(root.right, root.data, max));
   
        
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
	}

}
