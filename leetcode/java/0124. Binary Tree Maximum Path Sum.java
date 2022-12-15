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

// Time complexity:O(N), where N is the number of nodes
// Space complexity:O(N)

class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        this.dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode source) {

        if (source == null) {
            return 0;
        }

        int maxLeftNoSplit = Integer.max(this.dfs(source.left), 0);
        int maxRightNoSplit = Integer.max(this.dfs(source.right), 0);

        this.maxSum = Integer.max(this.maxSum, source.val + maxLeftNoSplit + maxRightNoSplit);

        return source.val + Integer.max(maxLeftNoSplit, maxRightNoSplit);
    }
}