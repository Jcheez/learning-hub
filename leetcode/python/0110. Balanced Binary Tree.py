# Time complexity: O(N), where N is the number of nodes
# Space complexity: O(N)

class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        if abs(self.getHeight(root.left) - self.getHeight(root.right)) <= 1:
            return self.isBalanced(root.left) and self.isBalanced(root.right)
        return False

    def getHeight(self, node):
        if node is None:
            return -1
        elif node.left == None and node.right == None:
            return 0
        else:
            return max(self.getHeight(node.left), self.getHeight(node.right)) + 1