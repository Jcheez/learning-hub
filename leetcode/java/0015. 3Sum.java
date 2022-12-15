package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time complexity: O(N^2)
// Space complexity: O(N)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int target = -nums[i];

            int left = i+1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (right > left) {
                if (nums[right] + nums[left] > target) {
                    right--;
                } else if (nums[right] + nums[left] < target) {
                    left++;
                } else {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (right > left && nums[left] == nums[left-1]) {
                        left += 1;
                    }
                }
            }
        }
        return res;
    }
}