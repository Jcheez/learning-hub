package leetcode.java;

// Time complexity: O(NlogN)
// Space complexity: O(1)

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int toRemove = 0;
        int prev = -999999;

        for (int[] interval : intervals) {
            if (prev == -999999) {
                prev = interval[1];
            } else if (prev > interval[0]) {
                toRemove += 1;
                prev = Integer.min(interval[1], prev);
            } else {
                prev = interval[1];
            }
        }
        return toRemove;
    }
}