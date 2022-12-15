package leetcode.java;

// Time complexity: O(E+V), where E are the edges and V are the vertices (grids)
// Space complexity: O(E+V)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int row, int col, int color, int prevColor) {

        if (row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col]==prevColor) {
            image[row][col] = color;
            this.dfs(image, row+1, col, color, prevColor);
            this.dfs(image, row-1, col, color, prevColor);
            this.dfs(image, row, col+1, color, prevColor);
            this.dfs(image, row, col-1, color, prevColor);
        }
    }
}