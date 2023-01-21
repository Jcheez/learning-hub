# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time complexity: O(N), where N is the number of nodes in the tree
# Space complexity: O(N)

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.helperSymmetric(root.left, root.right)
    
    def helperSymmetric(self, p, q):
        if p is not None and q is not None:
            return p.val == q.val and self.helperSymmetric(p.left, q.right) and self.helperSymmetric(p.right, q.left)
        elif p is None and q is None:
            return True
        return False