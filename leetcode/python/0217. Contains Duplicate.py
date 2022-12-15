# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def containsDuplicate(self, nums):
        storage = set()        
        for num in nums:
            if num in storage:
                return True
            else:
                storage.add(num)
        return False      