package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time complexity: O(NlogN)
// Space complexity: O(N)

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (res.size() == 0) {
                res.add(interval);
            } else {
                if (res.get(res.size() - 1)[1] >= interval[0]) {
                    res.get(res.size() - 1)[1] = Integer.max(interval[1], res.get(res.size() - 1)[1]);
                } else {
                    res.add(interval);
                }
            }
        }
        return res.stream().toArray(int[][]::new);
    }
}