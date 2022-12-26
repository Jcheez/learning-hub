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

// Time complexity: O(N), where N is the number of nodes in the tree
// Space complexity: O(N)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        this.in_order_traversal(root, order, 1);

        int left = 0;
        int right = order.size() - 1;

        while (right > left) {
            if (order.get(left) + order.get(right) == 0) {
                left += 1;
                right -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public void in_order_traversal(TreeNode root, List<Integer> order, int sign) {
        if (root != null) {
            this.in_order_traversal(root.left, order, -1);
            order.add(root.val == 0 ? 101*sign : root.val*sign);
            this.in_order_traversal(root.right, order, 1);
        }
    }
}