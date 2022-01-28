public class Solution {

	
    public static class Set<T,U,V,W>{
        int min;
        int max;
        boolean isBST;
        int height;
        Set(int min,int max, boolean isBST, int height){
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.height = height;
        }
    }
    
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		
        if(root==null) return 0;
        Set answer = largestBST(root);
        
        int answerh = answer.height;
        return answerh;
	}
    
    public static Set largestBST(BinaryTreeNode<Integer> root){
        
        if(root==null){
            Set ans = new Set(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);
    		return ans;
        }
        
        Set leftAns = largestBST(root.left);
        Set rightAns = largestBST(root.right);
        
        boolean rootBST = (leftAns.max < root.data) && (rightAns.min>root.data);
        
        int maxHeight = Math.max(leftAns.height,rightAns.height);
            
        if(leftAns.isBST == true && rightAns.isBST == true && rootBST){
            maxHeight ++; 
        }
        
        
        int lmin = Math.min(root.data,leftAns.min);
        int lmax = Math.max(root.data,leftAns.max);
        
        int rmin = Math.min(root.data,rightAns.min);
        int rmax = Math.max(root.data,rightAns.max);
        
        int overallMin = Math.min(lmin,rmin);
        int overallMax = Math.max(lmax,rmax);
        
        Set answerSet = new Set(overallMin,overallMax,rootBST,maxHeight);
        return answerSet;
        
        
    }

}

	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
