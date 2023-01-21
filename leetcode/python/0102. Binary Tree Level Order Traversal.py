# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time complexity: O(N), where N is the number of nodes
# Space complexity: O(N)

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []

        q = [root]

        while len(q) > 0:
            temp = q
            q = []
            level = []

            for n in temp:
                if n is not None:
                    level.append(n.val)
                    q.append(n.left)
                    q.append(n.right)
            if len(level) > 0:
                res.append(level)

        return res
