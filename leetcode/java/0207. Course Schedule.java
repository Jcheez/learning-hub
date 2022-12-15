package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Time complexity: O(V + E), where V is the number of courses, E is the number of edges
// Space complexity: O(V + E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        
        HashMap<Integer, List<Integer>> adjList = this.makeAdjList(numCourses, prerequisites);
        int[] visited = new int[numCourses];

        for (int i=0; i<numCourses; i++) {
            if (!this.dfs(adjList, visited, i)) {
                return false;
            }
        }

        return true;

    }

    public HashMap<Integer, List<Integer>> makeAdjList(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> res = new HashMap<>();
        
        for (int i=0; i< numCourses; i++) {
            res.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int to = prereq[1];
            int from = prereq[0];

            List<Integer> temp = res.get(to);
            temp.add(from);
            res.put(to, temp);
        }
        return res;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> adjList, int[] visited, int source) {
        
        if (visited[source] == 1) {
            return false;
        }

        visited[source] = 1;

        for (int n : adjList.get(source)) {
            if (!this.dfs(adjList, visited, n)) {
                return false;
            }
        }

        adjList.put(source,new ArrayList<>());
        visited[source] = 0;
        return true;
    }
}