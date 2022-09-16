package implementing_algorithms;

import java.util.Iterator;

public class DFS {
	Graph myGraph;

	public void DFSearch(int initVertex) {
		myGraph.getVisited()[initVertex] = true;
		System.out.print(initVertex + "  ");

		Iterator<Integer> iter = myGraph.getAdjList()[initVertex].listIterator();
		while (iter.hasNext()) {
			int adj = iter.next();
			if (!myGraph.getVisited()[adj])
				DFSearch(adj);
		}
	}

	public static void main(String[] args) {
		DFS myDFSearch = new DFS();
		myDFSearch.myGraph = new Graph(6);

		myDFSearch.myGraph.addEdge(0, 1);
		myDFSearch.myGraph.addEdge(0, 2);
		myDFSearch.myGraph.addEdge(0, 3);
		myDFSearch.myGraph.addEdge(1, 3);
		myDFSearch.myGraph.addEdge(3, 4);
		myDFSearch.myGraph.addEdge(4, 4);
		myDFSearch.myGraph.addEdge(5, 1);

		myDFSearch.DFSearch(0);
		System.out.println();
		myDFSearch.DFSearch(5); // vertex `1` is already visited
		System.out.println();

		myDFSearch.myGraph.initializeVisited();
		myDFSearch.DFSearch(3);
		System.out.println();
	}
}