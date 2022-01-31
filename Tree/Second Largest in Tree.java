
//Contains a very impotant logic
public class Solution {
    

    static TreeNode<Integer>  largest = new TreeNode<Integer>(Integer.MIN_VALUE);
    static TreeNode<Integer> secondLargest = new TreeNode<Integer>(Integer.MIN_VALUE);
    
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
		if(root==null) return null;
        findSecondLargest2(root);
        return secondLargest;
	}
    
    public static TreeNode<Integer> findSecondLargest2(TreeNode<Integer> root){
		if(root==null) return null;
        
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer> child = findSecondLargest(root.children.get(i));
            //This logic is very important
		if(child.data > largest.data){
                secondLargest = largest;
                largest = child;
            }
            else if( child.data> secondLargest.data && child.data<largest.data){
                secondLargest = child;
            }
        }
        if(root.data > largest.data){
                secondLargest = largest;
                largest = root;
            }
        else if(root.data > secondLargest.data && root.data<largest.data){
                secondLargest = root;
            }
        return root;
	}
	
	
}


/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
