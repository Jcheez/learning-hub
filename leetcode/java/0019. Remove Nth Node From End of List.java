package leetcode.java;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Time complexity: O(N)
// Space complexity: O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int numElements = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            numElements += 1;
        }

        int toLoop = numElements - n - 1;
        if (toLoop < 0) {
            return head.next;
        }

        temp = head;
        while (toLoop > 0) {
            temp = temp.next;
            toLoop -= 1;
        }
        temp.next = temp.next.next;
        return head;
    }
}