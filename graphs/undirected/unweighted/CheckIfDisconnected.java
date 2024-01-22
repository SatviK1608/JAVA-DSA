package graphs.undirected.unweighted;

import java.util.LinkedList;

public class CheckIfDisconnected{

    static class Graph{
        int vertices;
        LinkedList<Integer> adjList [];

        
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

    public static void isConnected(Graph graph){

        int vertices = graph.vertices;
        LinkedList<Integer> adjList [] = graph.adjList;
 
        boolean[] visited = new boolean[vertices];
  
        DFS(0, adjList, visited);
  
        int count = 0;
        for (int i = 0; i <visited.length ; i++) {
        	System.out.println(i+" "+visited[i]);
            if(visited[i])
                count++;
        }
        if(vertices==count){
            System.out.println("Given graph is connected");
        }else{
            System.out.println("Given graph is not connected");
        }
    }

    public static void DFS(int source, LinkedList<Integer> adjList [], boolean[] visited){
        
        visited[source] = true;

        for (int i = 0; i <adjList[source].size() ; i++) {
            int neighbor = adjList[source].get(i);
            if(visited[neighbor]==false){
                
                DFS(neighbor, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(3,2 );

        isConnected(graph);

        graph.addEdge(3, 4);
        isConnected(graph);
    }
}