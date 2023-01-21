# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time complexity: O(N), where N is the number of nodes
# Space complexity: O(N)

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if len(nums) > 0:
            mid = len(nums) # 2
            res = TreeNode(nums[mid])

            res.left = self.sortedArrayToBST(nums[0:mid])
            res.right = self.sortedArrayToBST(nums[mid+1:])

            return res