package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// Time complexity: O(V + E), where V is the number of vertices, E is the number of edges
// Space complexity: O(V + E)

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        return this.dfs(map, node);        
    }

    public Node dfs(HashMap<Integer, Node> map, Node n) {

        if (map.containsKey(n.val)) {
            return map.get(n.val);
        }
        
        Node copy = new Node(n.val);
        map.put(n.val, copy);

        for (Node neigh : n.neighbors) {
            copy.neighbors.add(this.dfs(map, neigh));
        }

        return copy;
    }
}