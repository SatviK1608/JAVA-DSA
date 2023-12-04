package trees;

import java.util.*;

public class Tree {
	private static class Node{
		private int data;
		private List<Node> children;
		
		public Node(int data){
			this.data=data;
			this.children=new ArrayList<>();
		}
		
		public int getData(){
			return data;
		}
		public void addChild(Node child){
			this.children.add(child);
		}
		public List<Node> getChildren(){
			return children;
		}
	}
	private Node root;
	

	public Tree(int data) {
		this.root=new Node(data);
	}
	
	public Node getRoot(){
		return root;
	}
	
	public void displayTree(){
		display(root,0);
	}
	
	private void display(Node node,int level){
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		System.out.println("->"+node.getData());
		
		List<Node> children=node.getChildren();
		for(Node child: children){
			display(child,level+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree myTree=new Tree(0);
		
		Node nodeA=new Node(1);
		Node nodeB=new Node(2);
		Node nodeC=new Node(3);
		Node nodeD=new Node(4);
		Node nodeE=new Node(5);
		
		
		nodeA.addChild(nodeB);
		nodeA.addChild(nodeC);
		nodeB.addChild(nodeD);
		nodeB.addChild(nodeE);
		
		
		myTree.getRoot().addChild(nodeA);
		
		
		Node root=myTree.getRoot();
		System.out.println("Root Node Data: "+root.getData());
		
		
		List<Node> childrenOfRoot=root.getChildren();
		for(Node child:childrenOfRoot){
			System.out.println("Child Node data: "+child.getData());
		}
		
		myTree.displayTree();

	}

}
