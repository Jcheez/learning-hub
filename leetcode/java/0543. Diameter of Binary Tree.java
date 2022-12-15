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

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxD = new int[1];
        this.helper(maxD, root);
        return maxD[0];
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(this.getHeight(root.left), this.getHeight(root.right));
    }

    public void helper(int[] maxD, TreeNode source) {

        if (source == null) {
            return;
        }
        maxD[0] = Integer.max(getHeight(source.left) + getHeight(source.right), maxD[0]);
        this.helper(maxD, source.left);
        this.helper(maxD, source.right);
    }
}