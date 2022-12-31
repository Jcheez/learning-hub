package leetcode.java;

// Time complexity: O(n^2)
// Space complexity: O(n^2)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int row=0; row<mat.length; row++) {
            for (int col=0; col<mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    this.dfs(0, res, mat, row+1, col);
                    this.dfs(0, res, mat, row-1, col);
                    this.dfs(0, res, mat, row, col+1);
                    this.dfs(0, res, mat, row, col-1);
                }
            }
        }
        return res;
    }

    public void dfs(int currDistance, int[][] res, int[][] original, int row, int col) {
        if (row>=0 && row<original.length && col>=0 && col<original[0].length && original[row][col] == 1 && (original[row][col] + currDistance < res[row][col] || res[row][col]==0)) {
            res[row][col] = original[row][col] + currDistance;
            this.dfs(currDistance+1, res, original, row+1, col);
            this.dfs(currDistance+1, res, original, row-1, col);
            this.dfs(currDistance+1, res, original, row, col+1);
            this.dfs(currDistance+1, res, original, row, col-1);
        }
    }
}