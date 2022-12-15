# Time complexity: O(N)
# Space complexity: O(N)


class Solution(object):
    def climbStairs(self, n):
        dp = [0 for _ in range(n+1)]
        return self.recur(dp, n)
    
    def recur(self, dp, n):
        if n <= 1:
            dp[n] = 1

        if dp[n] != 0:
            return dp[n]

        dp[n] = self.recur(dp,n-1) + self.recur(dp, n-2)
        
        return dp[n]