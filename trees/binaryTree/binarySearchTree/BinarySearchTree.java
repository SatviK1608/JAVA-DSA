package trees.binaryTree.binarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;

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

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(10);
        bst.add(15);
        bst.add(1);
        bst.add(20);
        bst.add(25);
        bst.add(5);
        bst.add(7);
        bst.add(6);
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

    }
}
