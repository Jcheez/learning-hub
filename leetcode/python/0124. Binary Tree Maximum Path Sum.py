# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time complexity:O(N), where N is the number of nodes
# Space complexity:O(N)

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        maxSum = [-99999]
        self.dfs(root, maxSum)
        return maxSum[0]

    def dfs(self, source, maxSum):

        if source is None:
            return 0
        
        maxLeft = max(self.dfs(source.left), 0)
        maxRight = max(self.dfs(source.right), 0)

        maxSum[0] = max(maxSum[0], maxLeft+maxRight+source.val)

        return source.val + max(maxLeft, maxRight)