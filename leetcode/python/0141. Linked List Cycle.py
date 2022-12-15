# Time complexity: O(N)
# Space complexity: O(1)

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def hasCycle(self, head):
        while head != None:
            if head.val is True:
                return True
            head.val = True
            head = head.next
        return False