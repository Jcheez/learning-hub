# Time complexity: O(N)
# Space complexity: O(N)

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def mergeTwoLists(self, list1, list2):
        res = ListNode()
        temp = res

        while list1 != None and list2 != None:
            if list1.val < list2.val:
                temp.val = list1.val
                list1 = list1.next
            else:
                temp.val = list2.val
                list2 = list2.next
            temp.next = ListNode()
            temp = temp.next
        
        if list1 == None:
            temp.val = list2.val
            temp.next = list2.next
        else:
            temp.val = list1.val
            temp.next = list1.next
        return res