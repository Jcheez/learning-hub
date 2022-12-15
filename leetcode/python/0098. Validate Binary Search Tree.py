# Time complexity: O(N)
# Space complexity: O(H), where H is the height of the tree

class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def isValidBST(self, root):
        sequence = []
        self.in_order(sequence, root)
        
        for i in range(1, len(sequence)):
            if sequence[i] <= sequence[i-1]:
                return False
        return True


    def in_order(self, lst, root):
        
        if root != None:
            self.in_order(lst, root.left)
            lst.append(root.val)
            self.in_order(lst, root.right)