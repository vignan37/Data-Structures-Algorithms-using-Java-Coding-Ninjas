public class Solution {

	public static int numNodeGreater(TreeNode<Integer> root,int x){

		if(root==null) return 0;
        int count=0;
        for(int i=0;i<root.children.size();i++){
            int numChildGreater = numNodeGreater(root.children.get(i) ,x);
            count = count + numChildGreater;
        }
		if(root.data>x) return count+1;
        else return count;
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

	
