# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def majorityElement(self, nums):
        freq_table = {}

        for num in nums:
            if num in freq_table:
                freq_table[num] += 1
            else:
                freq_table[num] = 1
        
        req = len(nums) / 2

        for num, count in freq_table.items():
            if count > req:
                return num
        return -1
        