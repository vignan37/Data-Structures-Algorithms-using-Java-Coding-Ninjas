
//edit code later

public class Solution {
	
    public static class NodeValuePair{
        TreeNode<Integer> node;
        int value;
        NodeValuePair(TreeNode<Integer> node, int value){
            this.node = node;
            this.value = value;
        }
    }
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		if(root==null) return null;
        NodeValuePair answer = maxSumNode2(root);
        return answer.node;
	}
    
   
    public static NodeValuePair ans = new NodeValuePair(null,Integer.MIN_VALUE);
    
    public static NodeValuePair maxSumNode2(TreeNode<Integer> root){
		if(root==null) return new NodeValuePair(null,Integer.MIN_VALUE);
        
        
        
        int childSum = 0;
        
        for(int i=0;i<root.children.size();i++){
            maxSumNode2(root.children.get(i));
            childSum = childSum+ root.children.get(i).data;
        }
        
        int totalSum = childSum + root.data;
        
        if(totalSum>ans.value){
            ans.node = root;
            ans.value = totalSum;
        }
        
        return ans;
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
	
