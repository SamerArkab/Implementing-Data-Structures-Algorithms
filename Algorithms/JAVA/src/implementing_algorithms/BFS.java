package implementing_algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	Graph myGraph;

	public void BFSearch(int initVertex) {
		LinkedList<Integer> q = new LinkedList<Integer>();

		myGraph.getVisited()[initVertex] = true;
		q.add(initVertex);

		while (q.size() != 0) {
			initVertex = q.poll();
			System.out.print(initVertex + "  ");

			Iterator<Integer> iter = myGraph.getAdjList()[initVertex].listIterator();
			while (iter.hasNext()) {
				int adj = iter.next();
				if (!myGraph.getVisited()[adj]) {
					myGraph.getVisited()[adj] = true;
					q.add(adj);
				}
			}
		}
	}

	public static void main(String[] args) {
		BFS myBFSearch = new BFS();
		myBFSearch.myGraph = new Graph(6);

		myBFSearch.myGraph.addEdge(0, 1);
		myBFSearch.myGraph.addEdge(0, 2);
		myBFSearch.myGraph.addEdge(0, 3);
		myBFSearch.myGraph.addEdge(1, 3);
		myBFSearch.myGraph.addEdge(3, 4);
		myBFSearch.myGraph.addEdge(4, 4);
		myBFSearch.myGraph.addEdge(5, 1);

		myBFSearch.BFSearch(0);
		System.out.println();
		myBFSearch.BFSearch(5); // vertex `1` is already visited
		System.out.println();

		myBFSearch.myGraph.initializeVisited();
		myBFSearch.BFSearch(3);
		System.out.println();
	}
}