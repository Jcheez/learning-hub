package leetcode.java;

// Time complexity: O(N)
// Time complexity: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int n : nums) {
            num ^= n;
        }
        return num;
    }
}