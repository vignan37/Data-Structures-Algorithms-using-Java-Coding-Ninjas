public class Solution {

	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

		if(root==null) return false;
        
        for(int i=0; i<root.children.size(); i++){
            boolean answer = checkIfContainsX(root.children.get(i),x);
            if(answer==true) return true;
        }
		
        if(root.data == x) return true;
        else return false;
	}
	
}


/*	TreeNode class 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
