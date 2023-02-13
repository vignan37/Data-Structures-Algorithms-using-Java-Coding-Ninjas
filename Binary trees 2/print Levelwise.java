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

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
        if(root==null) return;
        
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        
        q.add(root);
        
        while(q.isEmpty()==false){
            BinaryTreeNode<Integer> temp = q.poll();
            
            int left = -1;
            int right =-1;
            
            if(temp.left!=null){
                q.add(temp.left);
                left = temp.left.data;
            }
            
            if(temp.right!=null){
                q.add(temp.right);
                right = temp.right.data;
            }
            System.out.println(temp.data + ":L:" + left +",R:" + right);
        }
	}
	
}
