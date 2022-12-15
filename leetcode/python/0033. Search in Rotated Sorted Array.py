# Time complexity: O(logN)
# Space complexity: O(1)

class Solution(object):
    def search(self, nums, target):
        pivot = self.find_pivot(nums)
        firsthalf = self.bsearch(nums, target, 0, pivot-1)
        if firsthalf == -1:
            return self.bsearch(nums, target, pivot, len(nums)-1)
        return firsthalf


    def find_pivot(self, nums):
        left = 0
        right = len(nums) - 1
        if len(nums) == 1:
            return 0

        while right >= left:
            mid = (left + right) / 2

            if nums[mid] < nums[mid-1]:
                return mid
            elif nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid - 1
        return -1

    def bsearch(self, nums, target, left, right):
        while right >= left:
            mid = (left + right) / 2

            if nums[mid] == target:
                return mid
            elif target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return -1