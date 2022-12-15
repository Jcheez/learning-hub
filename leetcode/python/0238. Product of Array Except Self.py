# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def productExceptSelf(self, nums):

        prefix = [1 for _ in nums]
        suffix = [1 for _ in nums]
        res = []

        for idx in range(1, len(nums)):
            prefix[idx] *= prefix[idx-1] * nums[idx - 1]
        
        for idx2 in range(len(nums)-2, -1):
            suffix[idx2] *= suffix[idx2+1] * nums[idx2+1]

        for idx3 in range(len(nums)):
            res.append(prefix[idx3]* suffix[idx3])
        
        return res