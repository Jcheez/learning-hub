package leetcode.java;

// Time complexity: O(RC) where R is the num of rows, C is the number of cols
// Space complexity: O(RC) where R is the num of rows, C is the number of cols

class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    numIslands += 1;
                    this.dfs(grid, row, col);
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int row, int col) {
        
        if (row >= 0 && row <grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] = 'a';
            this.dfs(grid, row+1, col);
            this.dfs(grid, row-1, col);
            this.dfs(grid, row, col-1);
            this.dfs(grid, row, col+1);
        }
    }
}