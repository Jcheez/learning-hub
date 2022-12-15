# Time complexity: O(N)
# Space complexity: O(H), where H is the height of the tree

class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None
        
        head = preorder[0]
        mid = inorder.index(head)
        res = TreeNode(val=head)

        res.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        res.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])

        return res