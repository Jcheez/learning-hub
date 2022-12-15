package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(1)

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (right > left) {
            int width = right - left;
            int tempArea = width * Integer.min(height[left], height[right]);

            maxArea = Integer.max(tempArea, maxArea);

            if (height[left] > height[right]) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return maxArea;
    }
}