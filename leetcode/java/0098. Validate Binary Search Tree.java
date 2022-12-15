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

// Time complexity: O(N)
// Space complexity: O(H), where H is the height of the tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> storage = new ArrayList<>();
        this.in_order_traversal(root, storage);
        for (int i=1; i<storage.size(); i++) {
            if (storage.get(i) <= storage.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public void in_order_traversal(TreeNode root, List<Integer> storage) {
        if (root != null) {
            this.in_order_traversal(root.left, storage);
            storage.add(root.val);
            this.in_order_traversal(root.right, storage);
        }
    }
}