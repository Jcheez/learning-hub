# Time complexity: O(N!), where N is the size of nums
# Space complexity: O(N)

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        if len(nums) == 1:
            return [nums]
        
        for _ in range(len(nums)):
            element = nums.pop(0)
            subPermutations = self.permute(nums.copy())
            
            for perm in subPermutations:
                perm.append(element)
                res.append(perm)

            nums.append(element)
        return res
