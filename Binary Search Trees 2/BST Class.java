public class BinarySearchTree {
    
    BinaryTreeNode<Integer> root;
    
    
    public BinaryTreeNode<Integer>  insertHelper(BinaryTreeNode<Integer> root, int x ) {
		
        if(root==null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(x);
            return node;
        }
        
        if(root.data<x){
            BinaryTreeNode<Integer> node = insertHelper(root.right,x);
            root.right = node;
        }
        
        if(root.data>=x){
            BinaryTreeNode<Integer> node = insertHelper(root.left,x);
            root.left = node;
        }
        return root;
    }
    
    
	public void insert(int data) {
		root = insertHelper(root,data);
	}
	
    public BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root,int data){
		
		if(root==null) {
			return null;
		}
		if( root.data==data ) {
			
			if(root.left==null && root.right==null) {
				return null;
			}
			else if(root.left==null) {
				
				return root.right;
				
			}
			else if(root.right==null) {
				return root.left;
			}
			else {
				
				// inorder succeesor i.e. Right Subtree  Min 
				
				BinaryTreeNode<Integer> temp = root.right;
				while(temp.left!=null) {
					temp = temp.left;
				}
				int tempData = temp.data;
				root.data = tempData;
				root.right = remove(root.right,tempData);
				return root;
			}
			
		}
		
		
		
		if( data < root.data ) {
			
			root.left = remove(root.left, data);
			
		}
		else {
			root.right  = remove(root.right, data);
		}
		return root;
		
		
	}
	public void remove(int data) {
		root = remove(root,data);
	}
	
    private static void printTreeHelper(BinaryTreeNode<Integer> node){
        
        if(node==null) return;
//		N:L:x,R:y
		System.out.print(node.data+":");
		if(node.left!=null) {
			System.out.print("L:"+node.left.data+",");
		}
		if(node.right!=null) {
			System.out.print("R:"+node.right.data);
		}
        System.out.println();
		printTreeHelper(node.left);
		printTreeHelper(node.right);
    }

    public void printTree() {
		printTreeHelper(root);
	}
	
    private static boolean searchHelper(BinaryTreeNode<Integer> node,int x){
        if(node==null) return false;
        if(node.data == x) return true;
        if(x<node.data) return searchHelper(node.left,x);
        else return searchHelper(node.right,x);
    }
    
	public boolean search(int data) {
		return searchHelper(root,data);
	}
	
}

/*
 * Binary Tree Node class
 * 
 * class BinaryTreeNode<T> { 
 * 		T data; 
 * 		BinaryTreeNode<T> left; 
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data) 
 * 		{ 
 * 			this.data = data; 
 * 		}
 * }
 */

 /* 
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *				case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */

