package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i=0; i<=nums.length; i++) {
            if (i != nums.length) {
                res -= nums[i];
            }
            res += i;
        }
        return res;
    }
}