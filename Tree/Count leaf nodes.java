public class Solution {
	
	public static int countLeafNodes(TreeNode<Integer> root){

		if(root==null) return 0;
        
        if(root.children.size()==0) return 1;
        
        int numLeaf = 0;
        
        for(int i = 0 ; i<root.children.size(); i++){
            int totalChildrenLeafs = countLeafNodes(root.children.get(i));
             numLeaf = numLeaf + totalChildrenLeafs;
        }
		return numLeaf;
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
