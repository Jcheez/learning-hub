# Time Complexity: O(N)
# Space complexity: O(1)

class Solution(object):
    def maxProfit(self, prices):
        minimum = 99999
        max_price = 0
        for p in prices:
            if p < minimum:
                minimum = p
            else:
                max_price = max(max_price, p - minimum)
        return max_price