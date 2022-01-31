
public class Solution {

    public static TreeNode<Integer> answer = new TreeNode<Integer>(Integer.MAX_VALUE);
	
	
     public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		if(root==null) return null;
        findNextLargerNode2(root,n);
		return answer;
	}
    
    public static TreeNode<Integer> findNextLargerNode2(TreeNode<Integer> root, int n){
		
		if(root==null) return null;
        
        for(int i=0;i<root.children.size(); i++) {
            TreeNode<Integer> childAns = findNextLargerNode(root.children.get(i),n);
            if(childAns.data<answer.data && childAns.data>n){
                answer = childAns;
            }
        }
        if(root.data<answer.data && root.data>n){
                answer = root;
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
