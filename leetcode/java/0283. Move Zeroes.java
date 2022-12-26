package leetcode.java;

import java.util.LinkedList;
import java.util.Queue;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> q = new LinkedList<>();

        for (int num : nums) {
            if (num != 0) {
                q.add(num);
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (!q.isEmpty()) {
                nums[i] = q.poll();
            } else {
                nums[i] = 0;
            }
        }
    }
}