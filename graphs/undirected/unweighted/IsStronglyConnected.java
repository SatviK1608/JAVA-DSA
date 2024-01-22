package graphs.undirected.unweighted;

import java.util.LinkedList;

public class IsStronglyConnected{

    static class Graph{
        int vertices;
        LinkedList<Integer> adjList [];

        
		@SuppressWarnings("unchecked")
		public Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination){
            adjList[source].addFirst(destination);
            adjList[destination].addFirst(source);
        }
    }

    public static boolean isStronglyConnected(Graph graph){

        int vertices = graph.vertices;
        LinkedList<Integer> adjList [] = graph.adjList;
 
        
        //checking for degree of every node
        for(int i=0;i<vertices;i++){
        	if(adjList[i].size()!=vertices-1)
        		return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(3,2);
        graph.addEdge(0,2);
        graph.addEdge(0,3);

        System.out.println(isStronglyConnected(graph));

        
    }
}