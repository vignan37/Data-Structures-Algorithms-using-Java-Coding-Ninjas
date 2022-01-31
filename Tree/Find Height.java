public class Solution {


	public static int getHeight(TreeNode<Integer> root){
		
        if(root==null) return 0;
        
        if(root.children.size()==0) return 1;
        
        int height =0;
        
        for(int i=0;i<root.children.size();i++){
            
            int maxHeightOfChildren =  getHeight(root.children.get(i));
            
            if(maxHeightOfChildren>height) height = maxHeightOfChildren;
	    }
        return height+1;  
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
