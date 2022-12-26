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
    public TreeNode sortedArrayToBST(int[] nums) {
        return this.insert(nums, 0, nums.length-1);
    }

    public TreeNode insert(int[] nums, int left, int right) {
        if (right < left) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = this.insert(nums, left, mid-1);
        node.right = this.insert(nums, mid+1, right);
        
        return node;
    }
}