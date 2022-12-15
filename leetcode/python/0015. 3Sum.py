# Time complexity: O(N^2)
# Space complexity: O(N)

class Solution(object):
    def threeSum(self, nums):
        res = []
        nums.sort()

        for idx,num in enumerate(nums):
            target = -num

            left = idx+1
            right = len(nums) - 1

            if nums[idx] == nums[idx-1] and idx>0:
                continue

            while right > left:
                if nums[left] + nums[right] > target:
                    right -= 1
                elif nums[left] + nums[right] < target:
                    left += 1
                else:
                    res.append([num, nums[left], nums[right]])
                    left += 1
                    while right > left and nums[left] == nums[left-1]:
                        left += 1
          
        return res    