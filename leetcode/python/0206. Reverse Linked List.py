# Time complexity: O(N)
# Space complexity: O(1)

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def reverseList(self, head):
        prev = None
        curr = head
        while head != None:
            head = head.next
            curr.next = prev
            prev = curr
            curr = head
        return prev  