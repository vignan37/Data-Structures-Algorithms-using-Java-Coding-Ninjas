import java.util.*;
public class Solution {

    
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		
        if(root==null) return null;
    	
        ArrayList<LinkedListNode<Integer>> al = new  ArrayList<LinkedListNode<Integer>>();
        
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int counter = q.size();
            
            LinkedListNode<Integer> head = null; 
            LinkedListNode<Integer> tail = null;
            
                for(int i=0;i<counter;i++){
                    
                BinaryTreeNode<Integer> node = q.poll();
                
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                
                if(head== null){
                    LinkedListNode<Integer> newhead = new LinkedListNode<Integer>(node.data);
                    head = newhead;
                    tail = head;
                }
                else{
                    LinkedListNode<Integer> nextNode = new LinkedListNode<Integer>(node.data);
                    tail.next = nextNode;
                    tail = tail.next;
                }   
            }
            
            al.add(head);
            
        }
       return al; 
	}

}

	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	/*
	 * LinkedListNode Class
	 * class LinkedListNode<T> 
	 * { 
	 * 		T data; 
	 * 		LinkedListNode<T> next;
	 * 		public LinkedListNode(T data) 	
	 * 		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	
