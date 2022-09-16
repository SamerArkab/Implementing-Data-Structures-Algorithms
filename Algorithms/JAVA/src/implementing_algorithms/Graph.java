package implementing_algorithms;

import java.util.LinkedList;

public class Graph {
	private LinkedList<Integer>[] adjacencyList;
	private boolean[] visited;
	private int vertices;

	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];
		visited = new boolean[vertices];

		for (int i = 0; i < vertices; i++)
			adjacencyList[i] = new LinkedList<Integer>();
	}

	public void addEdge(int source, int dest) {
		adjacencyList[source].add(dest);
	}

	public LinkedList<Integer>[] getAdjList() {
		return adjacencyList;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public void initializeVisited() {
		for (int i = 0; i < vertices; i++)
			visited[i] = false;
	}
}