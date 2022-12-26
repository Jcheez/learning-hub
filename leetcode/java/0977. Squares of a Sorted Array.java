package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(N)

import java.util.Stack;

class Solution {
    public int[] sortedSquares(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int currFree = 0;
        int left = 0;
        while (left < nums.length) {
            if (nums[left] < 0) {
                stack.add(nums[left] * nums[left]);
                left += 1;
            } else {
                if (stack.isEmpty() || stack.peek() > nums[left]*nums[left]) {
                    res[currFree] = nums[left] * nums[left];
                    left += 1;
                } else {
                    res[currFree] = stack.pop();
                }
                currFree += 1;
            }
        }

        while (!stack.isEmpty()) {
            res[currFree] = stack.pop();
            currFree += 1;
        }
        return res;
    }
}