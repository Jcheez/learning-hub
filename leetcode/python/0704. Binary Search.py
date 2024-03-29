# Time complexity: O(logN)
# Space complexity: O(1)


class Solution(object):
    def search(self, nums, target):

        left = 0
        right = len(nums) - 1

        while right >= left:
            mid = (left + right) / 2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1