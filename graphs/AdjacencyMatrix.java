package graphs;

public class AdjacencyMatrix {
	
	private int[][] adjacencyMatrix;
	

	public AdjacencyMatrix(int nodes) {
		// TODO Auto-generated constructor stub
		this.adjacencyMatrix=new int[nodes][nodes];
	}
	
	public void addEdge(int source,int destination){
		this.adjacencyMatrix[source][destination]=1;
	}
	
	public void showMatrix(){
		for(int i=0;i<adjacencyMatrix.length;i++){
			for(int j=0;j<adjacencyMatrix[i].length;j++){
				System.out.print(adjacencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
