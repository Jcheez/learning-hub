package leetcode.java;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Time complexity: O(N), where N is the number of nodes
// Space complexity: O(1)

class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            length += 1;
        }

        length /= 2;

        while (length > 0) {
            head = head.next;
            length -= 1;
        }

        return head;
    }
}