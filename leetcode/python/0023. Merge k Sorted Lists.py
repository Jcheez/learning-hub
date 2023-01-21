import heapq

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Time complexity: O(NlogK), where K is the number of linked lists and N is the total number of nodes in lists
# Space complexity: O(N)

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """ 
        heap = []
        res = ListNode()
        temp = res
        for l in lists:
            if l is not None:
                heap.append([l.val, l.next])
        heapq.heapify(heap)
        while (len(heap) > 0):
            val, node = heapq.heappop(heap)
            if node is not None:
                heapq.heappush(heap, [node.val, node.next])
            temp.next = ListNode(val)
            temp = temp.next
        return res.next