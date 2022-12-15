package leetcode.java;

import java.util.ArrayList;
import java.util.List;

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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        this.in_order_traversal(root, lst);
        return lst.get(k-1);
    }

    public void in_order_traversal(TreeNode root, List<Integer> lst) {
        this.in_order_traversal(root.left, lst);
        lst.add(root.val);
        this.in_order_traversal(root.right, lst);
    }
}