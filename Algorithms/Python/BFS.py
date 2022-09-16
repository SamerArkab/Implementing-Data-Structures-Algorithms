# Breadth First Search
from collections import defaultdict


def add_edge(graph, source, destination):
    graph[source].append(destination)


def bfsearch(graph, start):
    visited = [False] * len(graph)
    queue = list()
    queue.append(start)
    visited[start] = True

    while queue:
        start = queue.pop(0)
        print(str(start) + " ", end='')
        for i in graph[start]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


my_graph = defaultdict(list)
add_edge(my_graph, 0, 1)
add_edge(my_graph, 0, 2)
add_edge(my_graph, 0, 3)
add_edge(my_graph, 1, 3)
add_edge(my_graph, 3, 4)
add_edge(my_graph, 4, 4)
add_edge(my_graph, 5, 1)

bfsearch(my_graph, 0)
print()

bfsearch(my_graph, 5)
print()
