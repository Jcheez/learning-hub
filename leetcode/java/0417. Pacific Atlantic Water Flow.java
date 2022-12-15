package leetcode.java;

// Time complexity: O(NM)
// Space complexity: O(NM)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        HashSet<String> pacific = new HashSet<>();
        HashSet<String> atlantic = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int row=0; row<heights.length; row++) {
            this.dfs(heights, row, 0, heights[row][0], pacific);
            this.dfs(heights, row, heights[0].length-1, heights[row][heights[0].length-1], atlantic);
        }

        for (int col=0; col<heights[0].length; col++) {
            this.dfs(heights, 0, col, heights[0][col], pacific);
            this.dfs(heights, heights.length-1, col, heights[heights.length-1][col], atlantic);
        }

        for (String co : pacific) {

            if (atlantic.contains(co)) {
                int commaIndex = co.indexOf(",");
                res.add(List.of(Integer.parseInt(co.substring(0, commaIndex)), Integer.parseInt(co.substring(commaIndex+1, co.length()))));
            }
        }
        return res;
    }

    public void dfs(int[][] heights, int row, int col, int prevHeight, HashSet<String> set) {
        if (row>=0 && row<heights.length && col>=0 && col<heights[0].length && heights[row][col] >= prevHeight && !set.contains(row + "," + col)) {
            set.add(row + "," + col);
            this.dfs(heights, row+1, col, heights[row][col], set);
            this.dfs(heights, row-1, col, heights[row][col], set);
            this.dfs(heights, row, col+1, heights[row][col], set);
            this.dfs(heights, row, col-1, heights[row][col], set);
        }
    }
}