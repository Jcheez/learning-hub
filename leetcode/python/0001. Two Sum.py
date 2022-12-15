# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def twoSum(self, nums, target):
        storage = {}
        
        for idx, num in enumerate(nums):
            remainder = target - num
            if remainder in storage:
                return [idx, storage[remainder]]
            else:
                storage[num] = idx
        return []

instance = Solution()
print(instance.twoSum([2,5,7,9], 12))