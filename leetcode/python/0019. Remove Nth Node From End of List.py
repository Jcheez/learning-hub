# Time complexity: O(N)
# Space complexity: O(1)

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def removeNthFromEnd(self, head, n):
        length = 0
        temp = head
        
        while temp != None:
            temp = temp.next
            length += 1

        if length == 1:
            return None
        
        toLoop = length - n - 1
        if toLoop == -1:
            return head.next
        
        temp = head
        for _ in range(toLoop):
            temp = temp.next

        temp.next = temp.next.next
        return head