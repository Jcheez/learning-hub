class Solution(object):
    def maxProduct(self, nums):
        curr_min = 1
        curr_max = 1
        global_max = -99999999

        for n in nums:
            temp_max = curr_max * n
            curr_max = max(n, temp_max, curr_min*n)
            curr_min = min(n, temp_max, curr_min*n)
            global_max = max(curr_max, global_max)
        return global_max