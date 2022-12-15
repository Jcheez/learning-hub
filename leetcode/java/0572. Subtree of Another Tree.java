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

// Time complexity: O(MN), where M is the number of nodes in subroot and N is the number of nodes in root
// Space complexity: O(M+N)

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (this.isSame(root, subRoot)) {
            return true;
        }

        if (root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode sub) {
        if (root == null || sub == null){
            return root == null && sub == null;
        }
        return root.val == sub.val && isSame(root.left, sub.left) && isSame(root.right, sub.right);
    }
}