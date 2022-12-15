# Time complexity: O(N)
# Space complexity: O(1)

class Solution(object):
    def maxArea(self, height):
        maxArea = 0
        width = len(height) - 1

        left = 0
        right = len(height) - 1

        while right > left:
            tempArea = min(height[left], height[right]) * width
            if height[left] > height[right]:
                right -= 1
            else:
                left += 1
            maxArea = max(tempArea, maxArea)
            width -= 1
        return maxArea