# Time complexity: O(logN)
# Space complexity: O(1)

class Solution(object):
    def findMin(self, nums):
        return nums[self.find_pivot(nums)]
    
    def find_pivot(self, nums):
        left = 0
        right = len(nums) - 1

        while right >= left:
            mid = (left + right) / 2

            if nums[mid] < nums[mid-1]:
                return mid
            elif nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid  - 1
        return -1