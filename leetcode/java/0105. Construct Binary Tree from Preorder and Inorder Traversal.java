package leetcode.java;

import java.util.Arrays;
import java.util.stream.IntStream;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length > 0 && inorder.length > 0) {
            TreeNode res = new TreeNode(preorder[0]);
            int pivot = this.indexOf(inorder, preorder[0]);
            res.left = this.buildTree(Arrays.copyOfRange(preorder, 1, pivot), Arrays.copyOfRange(inorder, 0, pivot));
            res.right = this.buildTree(Arrays.copyOfRange(preorder, pivot+1, preorder.length), Arrays.copyOfRange(inorder, pivot+1, inorder.length));
            return res;
        }
        return null;
    }

    public int indexOf(int[] arr, int target) {
        return IntStream.range(0, arr.length)
            .filter(x -> target == arr[x])
            .findFirst()
            .orElse(-1);
    }
}
