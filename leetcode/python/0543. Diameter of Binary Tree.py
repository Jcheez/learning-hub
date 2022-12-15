'''
count the number of edges not just from the root, but from the subtrees
'''

class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def diameterOfBinaryTree(self, root):
        res = [0]
        self.countEdges(root, res)
        return res[0]
        
    def countEdges(self, root, res):
        if root == None:
            return 0
        l = self.countEdges(root.left, res)
        r = self.countEdges(root.right, res)
        res[0] = max(res[0], l+r)
        return 1 + max(l, r)