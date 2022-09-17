package implementing_algorithms;

public class Dijkstra {
	public void dijkstra(int[][] graph, int source) {
		int graphLen = graph.length;
		boolean[] visitedVertex = new boolean[graphLen];
		int[] distance = new int[graphLen];
		for (int i = 0; i < graphLen; i++) { // initialize
			visitedVertex[i] = false;
			distance[i] = Integer.MAX_VALUE; // like an infinite distance to start with
		}

		distance[source] = 0; // start here
		for (int i = 0; i < graphLen; i++) {
			int minDistVertex = findMinDistance(distance, visitedVertex);
			visitedVertex[minDistVertex] = true;
			// update the distance of all neighboring vertices
			for (int v = 0; v < graphLen; v++)
				if (!visitedVertex[v] && graph[minDistVertex][v] != 0
						&& (distance[minDistVertex] + graph[minDistVertex][v] < distance[v]))
					distance[v] = distance[minDistVertex] + graph[minDistVertex][v];
		}
		// print distances
		for (int i = 0; i < distance.length; i++)
			System.out.println("Distance from " + source + " to " + i + " is " + distance[i]);
	}

	private int findMinDistance(int[] distance, boolean[] visitedVertex) {
		int minDist = Integer.MAX_VALUE;
		int minDistVertex = -1;
		for (int i = 0; i < distance.length; i++)
			if (!visitedVertex[i] && distance[i] < minDist) { // find the minimum distance
				minDist = distance[i];
				minDistVertex = i;
			}
		return minDistVertex;
	}

	public static void main(String[] args) {
		Dijkstra myDijkstra = new Dijkstra();
		int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
				{ 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };

		myDijkstra.dijkstra(graph, 1);
	}
}