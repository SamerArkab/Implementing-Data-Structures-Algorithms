class Dijkstra:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[0 for _ in range(vertices)]
                      for _ in range(vertices)]

    def dijkstra(self, source):
        dist = [1e7] * self.V
        dist[source] = 0
        shortest_path_tree = [False] * self.V
        for _ in range(self.V):
            u = self.min_distance(dist, shortest_path_tree)
            shortest_path_tree[u] = True
            for v in range(self.V):
                if self.graph[u][v] > 0 and not shortest_path_tree[v] and dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]
        self.print_sol(dist)

    def min_distance(self, dist, shortest_path_tree):
        minimum = 1e7  # Acts like infinite distance
        min_index = 0
        for v in range(self.V):
            if dist[v] < minimum and not shortest_path_tree[v]:
                minimum = dist[v]
                min_index = v
        return min_index

    def print_sol(self, dist):
        print("Vertex\tDistance from source")
        for vert in range(self.V):
            print(vert, "\t\t", dist[vert])


my_dijkstra = Dijkstra(9)
my_dijkstra.graph = [[0, 4, 0, 0, 0, 0, 0, 8, 0],
                     [4, 0, 8, 0, 0, 0, 0, 11, 0],
                     [0, 8, 0, 7, 0, 4, 0, 0, 2],
                     [0, 0, 7, 0, 9, 14, 0, 0, 0],
                     [0, 0, 0, 9, 0, 10, 0, 0, 0],
                     [0, 0, 4, 14, 10, 0, 2, 0, 0],
                     [0, 0, 0, 0, 0, 2, 0, 1, 6],
                     [8, 11, 0, 0, 0, 0, 1, 0, 7],
                     [0, 0, 2, 0, 0, 0, 6, 7, 0]
                     ]
my_dijkstra.dijkstra(0)
