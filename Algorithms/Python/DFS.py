# Depth First Search
def dfsearch(graph, start, visited=None):
    if visited is None:
        visited = []
    if start not in visited:
        visited.append(start)
        if start not in graph:
            return visited
        for next_vert in graph[start]:
            visited = dfsearch(graph, next_vert, visited)
    return visited


# Building graph
my_graph = {
    '0': ['1', '2', '3'],
    '1': ['3'],
    '3': ['4'],
    '4': ['4'],
    '5': ['1']
}

path = dfsearch(my_graph, '0')
print(" ".join(path))

path = dfsearch(my_graph, '5')
print(" ".join(path))
