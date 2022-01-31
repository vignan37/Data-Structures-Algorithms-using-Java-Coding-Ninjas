public class Solution {

	
	public static void replaceWithDepthValue(TreeNode<Integer> root){
		replaceWithDepthValue(root,0);
        
	}	


	public static void replaceWithDepthValue(TreeNode<Integer> root,int depth){
		
        if(root==null) return;
        
        root.data = depth;
        
        for(int i=0;i<root.children.size();i++){
     			
            replaceWithDepthValue(root.children.get(i),depth+1);
            
        }
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
