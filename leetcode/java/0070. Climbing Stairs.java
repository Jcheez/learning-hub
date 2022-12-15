package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[46];
        return this.helper(n, dp);
    }

    public int helper(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = this.helper(n-1, dp) + this.helper(n-2, dp);

        return dp[n];
    }
}