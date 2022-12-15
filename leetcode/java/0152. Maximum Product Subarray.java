package leetcode.java;

class Solution {
    public int maxProduct(int[] nums) {
        int currMin = 1;
        int currMax = 1;
        int maximum = -99;

        for (int num : nums) {
            int tempMax = currMax * num;
            currMax = Integer.max(Integer.max(currMin*num, tempMax), num);
            currMin = Integer.min(Integer.min(currMin*num, tempMax), num);

            maximum = Integer.max(maximum, currMax);
        }
        return maximum;
    }
}