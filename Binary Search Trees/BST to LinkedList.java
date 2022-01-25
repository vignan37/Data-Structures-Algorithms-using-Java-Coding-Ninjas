public class Solution {

	    static class DoubleNode<T,V>{
         T head;
         V tail;
         DoubleNode(T head,V tail){
            this.head=head;
            this.tail = tail;
        }
    }
  
  public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		if(root==null) return null;
        DoubleNode<LinkedListNode<Integer>,LinkedListNode<Integer>> answer = constructLinkedList2(root);
         return answer.head; 
	}
    
    
    
    public static DoubleNode constructLinkedList2(BinaryTreeNode<Integer> root) {
          if( root==null ) {
			DoubleNode<LinkedListNode<Integer>,LinkedListNode<Integer>> ans = new DoubleNode<LinkedListNode<Integer>, LinkedListNode<Integer>>(null, null);
			return ans;
		}
		DoubleNode<LinkedListNode<Integer>,LinkedListNode<Integer>> leftDoubleNode = constructLinkedList2(root.left);
		
        DoubleNode<LinkedListNode<Integer>,LinkedListNode<Integer>> rightDoubleNode= constructLinkedList2(root.right);
		
        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);

		if(leftDoubleNode.tail!=null)
			leftDoubleNode.tail.next = newNode;
		else
			leftDoubleNode.head = newNode;
		if(rightDoubleNode.head!=null)
			newNode.next = rightDoubleNode.head;
		else
			rightDoubleNode.tail = newNode;
		DoubleNode<LinkedListNode<Integer>,LinkedListNode<Integer>> answer = new DoubleNode<LinkedListNode<Integer>, LinkedListNode<Integer>>(leftDoubleNode.head, rightDoubleNode.tail);
		return answer;

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

	/*
	 * LinkedList Node Class
	 *
	 * 
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 * 
	 * public LinkedListNode(T data) { this.data = data; } }
	 */
