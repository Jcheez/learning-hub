package leetcode.java;

import java.util.ArrayList;
import java.util.List;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (newInterval[1] < start) {
                res.add(newInterval);
                for (int j=i; j<intervals.length; j++) {
                    res.add(intervals[j]);
                }
                return res.stream().toArray(int[][]::new);
            } else if (newInterval[0] > end) {
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);

        return res.stream().toArray(int[][]::new);
    }
}