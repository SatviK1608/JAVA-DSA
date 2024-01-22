package trees.binaryTree.binarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;



class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }
    public Node getRoot(){
    	return root;
    }
    public void add(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node currentRoot, int value) {
        // Case 1: When root is null
        if (currentRoot == null) {
            return new Node(value);
        }

        // Case 2: When root is not null
        if (value < currentRoot.getValue())
            currentRoot.setLeft(addNode(currentRoot.getLeft(), value));
        else
            currentRoot.setRight(addNode(currentRoot.getRight(), value));

        return currentRoot;
    }
    
    private int findMinNode(Node subRoot){
    	int min=subRoot.value;
    	
    	while(subRoot.left!=null){
    		min=subRoot.left.value;
    		subRoot=subRoot.left;
    	}
    	return min;
    }
    
    private Node deleteNode(Node root,int value){
    	if(root==null)
    		return root;
    	if(value<root.getValue())
    		root.left=deleteNode(root.left,value);
    	else if(value>root.value)
    		root.right=deleteNode(root.right,value);
    	else
    		if(root.left==null)
    			return root.right;
    		else if(root.right==null)
    			return root.left;
    		else
    			root.value=findMinNode(root.right);
    			root.right=deleteNode(root.right,root.value);
    			
    	return root;	
    	
    }
    
    
    
    /*
     * To delete a node their are two approaches 
     * 	Approach 1-> i. Choose the largest ele from left sub tree
     * 				ii. 
     * 	Approach 2-> i. Choose the smallest ele from right sub tree
     * 				ii. Replace the value of node to be deleted with the chosen smallest ele
     * 			   iii. Remove the min ele from right sub tree
     */

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
        System.out.println();
    }

    private void levelOrderTraversal(Node currentRoot) {
        if (currentRoot == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(currentRoot);

        Node node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.getValue() + " ");
            if (node.getLeft() != null) queue.add(node.getLeft());
            if (node.getRight() != null) queue.add(node.getRight());
        }
    }

    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node currentRoot, int value) {
        if (currentRoot == null) return false;

        if (currentRoot.getValue() == value) return true;

        if (value < currentRoot.getValue())
            return searchNode(currentRoot.getLeft(), value);

        return searchNode(currentRoot.getRight(), value);
    }
    
    
    public void invert(){
    	root=invert(root);
    }
    public Node invert(Node root){
    	if(root==null)
    		return null;
    	
    	//Swap left and right subtrees recrusively
    	Node left=invert(root.left);
    	Node right=invert(root.right);
    	
    	//swap the left and right subtrees for current node
    	root.left=right;
    	root.right=left;
    	
    	return root;
    }
    
    
    //Check if subtree is present in binary search tree
    	//->Follow any order but not level order
    	//->Here we compare pre-order of both trees but in case of null encountered we'll add it to our order 
    
    public boolean isSubtree(Node s,Node t){
    	String sTree=preOrderTraversal(s);
    	String tTree=preOrderTraversal(t);
    	
    	System.out.println("Parent pre order : "+sTree);
    	System.out.println("Child pre order : "+tTree);
    	
    	return sTree.contains(tTree);
    }
    
    public String preOrderTraversal(Node node){
    	if(node==null){
    		return "null";
    	}
    	StringBuilder sb=new StringBuilder();
    	sb.append("#").append(node.value);
    	sb.append(preOrderTraversal(node.left));
    	sb.append(preOrderTraversal(node.right));
    	
    	return sb.toString();
    	
    }
    
    
    public boolean isSame(Node s,Node t){
    	String sTree=preOrderTraversal(s);
    	String tTree=preOrderTraversal(t);
    	
    	System.out.println("Parent pre order : "+sTree);
    	System.out.println("Clone pre order : "+tTree);
    	
    	
    	return sTree.equals(tTree);
    }
    
    
    
    
    
    //Views  ->  https://iq.opengenus.org/views-in-binary-tree/
    	/*
    	 * 				6
    	 * 			4		8
    	 * 		  3   5	  7   9
    	 * 
    	 * 		Top view   	:   3,4,6,8,9 
    	 * 		Left view  	:	6,4,3
    	 * 		Right view 	:	6,8,9
    	 * 		Bottom view :	3,4,7,8,9
    	 */
    
    public static int maxlevel=-1;
    void leftview(Node node,int level){

    	if(node==null){
    		return;
    	}
    	if(maxlevel<level){
    		System.out.print(node.value+" ");
    		maxlevel=level;
    	}
    	leftview(node.left,level+1);
    	leftview(node.right,level+1);
    	
    }
    void rightview(Node node,int level){
    	
    	if(node==null){
    		return;
    	}
    	if(maxlevel<level){
    		System.out.print(node.value+" ");
    		maxlevel=level;
    	}
    	rightview(node.right,level+1);
    	rightview(node.left,level+1);
    	
    	
    }
    void topview(Node root){
    	
    	Node curr=root;
    	
        Stack<Node> stack = new Stack<Node>();
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.value + " ");
        }
        
        curr = root.right;
        while(curr != null){
            System.out.print(curr.value + " ");
            curr = curr.right;
        }
        
        
        
      
    	
    }
    
    void bottomview(Node root){
    	

    	
    }
   
    

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(10);
        bst.add(15);
        bst.add(1);
        bst.add(20);
        bst.add(25);
        bst.add(5);
        bst.add(7);
        bst.add(12);
        bst.add(-4);
        bst.add(18);
        bst.add(8);

        
        /*
                    10
              1            15
          -4     5     12     20
                   7        18    25
                 	8
         */
        //bst.deleteNode(bst.getRoot(),7);
        //bst.deleteNode(bst.getRoot(),1);
        

        bst.levelOrderTraversal();
        
        
        	
        
        bst.invert();
        
        /* INVERTED
         * 
        	    10
  		 15             1
	  20    12      5      -4
       		  25         18   7
       		    8
         */
        
        bst.levelOrderTraversal();
        
        
        BinarySearchTree parent = new BinarySearchTree();
        BinarySearchTree child = new BinarySearchTree();
        

        parent.add(6);
        parent.add(4);
        parent.add(8);
        parent.add(3);
        parent.add(5);
        parent.add(7);
        parent.add(9);
        
        child.add(4);
        child.add(3);
        child.add(5);
        
        System.out.println("IS IT A SUBTREE? : "+bst.isSubtree(parent.getRoot(), child.getRoot()));
        
        
        
        BinarySearchTree clone = new BinarySearchTree();
        
        
        clone.add(6);
        clone.add(4);
        clone.add(8);
        clone.add(3);
        clone.add(5);
        clone.add(7);
        clone.add(9);
        
        System.out.println("IS IT A CLONE? : "+bst.isSame(parent.getRoot(), clone.getRoot()));
        

        BinarySearchTree view = new BinarySearchTree();
        view.add(6);
        view.add(4);
        view.add(8);
        view.add(3);
        view.add(5);
        view.add(7);
        view.add(9);
        
        view.levelOrderTraversal();
        
        System.out.print("Left View : ");view.leftview(view.getRoot(),0);
        BinarySearchTree.maxlevel=-1;
        System.out.print("\nRight View : ");view.rightview(view.getRoot(),0);
        System.out.print("\nTop View : ");view.topview(view.getRoot());
        System.out.print("\nBottom View : ");view.bottomview(view.getRoot());
   
        
    }
}
