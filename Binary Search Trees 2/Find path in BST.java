import java.util.ArrayList;

public class Solution {


	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		if(root==null) return null;
    
    ArrayList<Integer> al = new ArrayList<Integer>();
    boolean answer = getPath(root,data,al);
        return al;
	}
    
    
    public static boolean getPath(BinaryTreeNode<Integer> root, int data,ArrayList<Integer> al){
		if(root==null) return false;
        
        else if(root.data>data) {
            boolean l = getPath(root.left,data,al);
        	if(l == true ){
                al.add(root.data);
            	return true;
            }
            else return false;   
        }
        
        
        else if(root.data<data) {
            boolean r = getPath(root.right,data,al);
            if(r==true){
                al.add(root.data);
            	return true;
            }
            else return false;
        }
        
        else if(root.data==data) {al.add(root.data); return true;}
        
        else return false;
	}
}

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 * 		public BinaryTreeNode(T data) 
	 * 		{ 
	 * 			this.data = data; 
	 * 		}
	 * }
	 */
