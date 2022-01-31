public class Solution {


	public static void printPostOrder(TreeNode<Integer> root){
    	 printPostOrderr(root);
        
	}
    
    public static TreeNode<Integer> printPostOrderr(TreeNode<Integer> root){
		if(root==null) return null;
        
        for(int i=0;i<root.children.size();i++){
            
            TreeNode<Integer> node = printPostOrderr(root.children.get(i));
            
        }
        System.out.print(root.data +  " ");
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
