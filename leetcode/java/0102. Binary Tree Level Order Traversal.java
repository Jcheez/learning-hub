package leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Time complexity: O(N), where N is the number of nodes
// Space complexity: O(N)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> qtemp = new LinkedList<>();
            
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    temp.add(curr.val);
                    qtemp.add(curr.left);
                    qtemp.add(curr.right);
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp);
            }
            q = qtemp;
        }
        return res;
    }
}