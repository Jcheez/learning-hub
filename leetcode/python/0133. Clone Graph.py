# Time complexity: O(V + E), where V is the number of vertices, E is the number of edges
# Space complexity: O(V + E)

class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution(object):
    def cloneGraph(self, node):
        if node is None:
            return node
        storage = {}
        return self.dfs(storage, node)

    def dfs(self, storage, node):
        if node in storage:
            return storage[node]

        copy = Node(node.val)
        storage[node] = copy

        for n in node.neighbors:
            copy.neighbors.append(self.dfs(storage, n))
        
        return copy