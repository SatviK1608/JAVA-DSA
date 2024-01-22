package graphs.undirected.unweighted;

import java.util.ArrayList;

public class AdjacencyList {

	ArrayList<ArrayList<Integer>> adjacencyList;
	public AdjacencyList(int nodes) {
		// TODO Auto-generated constructor stub
		this.adjacencyList=new ArrayList<ArrayList<Integer>>(nodes);
		for(int i=0;i<nodes;i++){
			adjacencyList.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int src,int dest){
		this.adjacencyList.get(src).add(dest);
		this.adjacencyList.get(dest).add(src);
	}
	
	public void showList(){
		for(int i=0;i<adjacencyList.size();i++){
			System.out.print(i);
			for(int j=0;j<adjacencyList.get(i).size();j++){
				System.out.print(" -> "+adjacencyList.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyList obj=new AdjacencyList(4);
		obj.addEdge(0, 1);
		obj.addEdge(0, 3);
		obj.addEdge(1, 2);
		obj.addEdge(2, 3);
		
		obj.showList();
		

	}

}
