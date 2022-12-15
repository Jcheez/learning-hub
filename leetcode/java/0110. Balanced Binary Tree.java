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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(this.getHeight(root.left) - this.getHeight(root.right)) <= 1) {
            return this.isBalanced(root.left) && this.isBalanced(root.right);
        }
        return false;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(this.getHeight(root.left), this.getHeight(root.right));
    }
}