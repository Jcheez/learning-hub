# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Time complexity: O(N)
# Space complexity: O(N)

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        res = ListNode()
        temp = res

        carry = 0

        while l1 is not None and l2 is not None:
            curr_value = l1.val + l2.val + carry
            carry = 0
            temp.next = ListNode(val=(curr_value % 10))

            if curr_value >= 10:
                carry = 1

            temp = temp.next

            l1 = l1.next
            l2 = l2.next

        while l1 is not None:
            curr_value = l1.val + carry
            carry = 0
            temp.next = ListNode(val=(curr_value % 10))
            if curr_value >= 10:
                carry = 1
            temp = temp.next
            l1 = l1.next

        while l2 is not None:
            curr_value = l2.val + carry
            carry = 0
            temp.next = ListNode(val=(curr_value % 10))
            if curr_value >= 10:
                carry = 1
            temp = temp.next
            l2 = l2.next

        if carry > 0:
            temp.next = ListNode(val=1)

        return res.next