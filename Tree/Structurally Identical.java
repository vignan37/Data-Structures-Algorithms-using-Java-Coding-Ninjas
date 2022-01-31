public class Solution {

	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		if(root1==null && root2==null) return true;
        if(root1.children.size() != root2.children.size() || root1.data != root2.data) return false;
		
        for(int i=0;i<root1.children.size();i++){
            boolean answer = checkIdentical(root1.children.get(i),root2.children.get(i));
            if(answer == false) return false;
        }
        if(root1.data == root2.data && root1.children.size() == root2.children.size()) return true;
        else return false;
    
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
