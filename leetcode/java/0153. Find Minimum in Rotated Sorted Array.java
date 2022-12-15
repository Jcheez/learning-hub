package leetcode.java;

// Time complexity: O(logN)
// Space complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] < nums[mid-1 == -1 ? right : mid-1]) {
                return nums[mid];
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[0];
    }
}