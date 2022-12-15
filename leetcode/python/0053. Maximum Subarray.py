# Time complexity: O(N)
# Space complexity: O(1)

class Solution(object):
    def maxSubArray(self, nums):
        curr_sum = 0
        maximum = -99999

        for num in nums:
            if curr_sum < 0:
                curr_sum = num
            else:
                curr_sum += num
            maximum = max(maximum, curr_sum)
        return maximum