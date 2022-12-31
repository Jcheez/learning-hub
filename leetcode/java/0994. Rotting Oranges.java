package leetcode.java;

import java.util.LinkedList;
import java.util.Queue;

// Time complexity: O(R*C) where R is number of rows and C is number of columns
// Space complexity: O(R*C)

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numOranges = 0;
        int minutes = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1) {
                    numOranges += 1;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i+1, j});
                    q.add(new int[]{i-1, j});
                    q.add(new int[]{i, j+1});
                    q.add(new int[]{i, j-1});
                }
            }
        }

        while (numOranges > 0 && !q.isEmpty()) {
            Queue<int[]> temp = new LinkedList<>(q);
            q.clear();
            while (!temp.isEmpty()) {
                int[] curr = temp.poll();

                if (curr[0]>=0 && curr[0]<rows && curr[1]>=0 && curr[1]<cols && grid[curr[0]][curr[1]] == 1) {
                    numOranges -= 1;
                    grid[curr[0]][curr[1]] = 2;
                    q.add(new int[]{curr[0]+1, curr[1]});
                    q.add(new int[]{curr[0]-1, curr[1]});
                    q.add(new int[]{curr[0], curr[1]+1});
                    q.add(new int[]{curr[0], curr[1]-1});
                }
            }
            minutes += 1;
        }
        return numOranges == 0 ? minutes : -1;


    }
}