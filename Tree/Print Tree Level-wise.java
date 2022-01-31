import java.util.*;
public class Solution {
	
	public static void printLevelWise(TreeNode<Integer> root){
		if(root==null) return;
		
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int qSize = q.size();
            
            for(int i=0;i<qSize;i++){
                TreeNode<Integer> node = q.poll();
                System.out.print(node.data +" ");
                
                for(int j=0;j<node.children.size();j++){
                q.add(node.children.get(j));
            	}
                
            }
            System.out.println();
  
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
