public class Solution {
		
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
			  if(arr.length==0) return null;
        else return SortedArrayToBST(arr,0,n-1);
		}
    	
    	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr,int si, int ei){
            if(si>ei) return null;
            int mid = (si+ei)/2 ;
            BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
            root.left = SortedArrayToBST(arr,si,mid-1);
            root.right = SortedArrayToBST(arr,mid+1,ei);
            return root;
        }
	}
  

//Find the mid of array, create node of it & then recusively call for its left and right with index values changing
  
  /*	Binary Tree Node class 
	 * 
	 * 	class BinaryTreeNode<T> {
			T data;
			BinaryTreeNode<T> left;
			BinaryTreeNode<T> right;
			
			public BinaryTreeNode(T data) {
				this.data = data;
			}
		}
		*/
	
    
