# Time complexity: O(N), where N is the number of nodes
# Space complexity: O(1)

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def middleNode(self, head):
        temp = head
        length = 0
        while temp != None:
            length += 1
            temp = temp.next
        
        mid = length / 2
        toLoop = length - mid - 1
        if length % 2 == 0:
            toLoop += 1

        while toLoop > 0:
            head = head.next
            toLoop -= 1
        return head