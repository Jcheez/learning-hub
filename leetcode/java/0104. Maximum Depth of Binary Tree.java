package leetcode.java;

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
    public int maxDepth(TreeNode root) {
        return this.dfs(root);
    }

    public int dfs(TreeNode source) {
        if (source == null) {
            return 0;
        } else if (source.left == null && source.right == null) {
            return 1;
        } else {
            return 1 + Integer.max(this.dfs(source.left), this.dfs(source.right));
        }
    }
}