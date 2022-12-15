# Time complexity: O(V + E), where V is the number of courses, E is the number of edges
# Space complexity: O(V + E)

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        visited = [0 for _ in range(numCourses)]
        recstack = [0 for _ in range(numCourses)]
        adj_list = {x:[] for x in range(numCourses)}
        
        for pre,post in prerequisites:
            if pre in adj_list:
                adj_list[pre].append(post)
        
        for node in adj_list.keys():
            if visited[node] == False:
                if self.findCycle(node, visited, recstack, adj_list):
                    return False
        return True
        

    def findCycle(self, node, visited, recstack, adjList):
        visited[node] = 1   
        recstack[node] = 1

        for n in adjList[node]:
            if visited[n] == 0:
                if self.findCycle(n, visited, recstack, adjList) == True:
                    return True

            elif recstack[n] == 1:
                return True
        
        recstack[node] = 0
        return False
        