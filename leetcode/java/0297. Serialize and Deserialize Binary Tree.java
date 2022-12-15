package leetcode.java;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Time complexity:O(N) where N is the number of nodes
// Space complexity:O(N) where N is the number of nodes

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "!";
        }
        return root.val + " " + serialize(root.left) + " " + this.serialize(root.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] arr = data.split(" ");
        int[] currPos = new int[]{-1};

        return this.deserializeHelper(arr, currPos);
    }

    public TreeNode deserializeHelper(String[] nodes, int[] currPos) {
        currPos[0] += 1;
        if (nodes[currPos[0]].equals("!")) {
            return null;
        }
        System.out.println(nodes[currPos[0]]);
        TreeNode res = new TreeNode(Integer.valueOf(nodes[currPos[0]]));
        res.left = this.deserializeHelper(nodes, currPos);
        res.right = this.deserializeHelper(nodes, currPos);
        return res;
    }
}