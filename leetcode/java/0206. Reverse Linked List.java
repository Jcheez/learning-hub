package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(1)

// Provided class
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode curr = head;
        while (head != null) {
            ListNode temp = curr;
            head = head.next;
            curr = curr.next;
            temp.next = res;
            res = temp;
        }
        return res;
    }
}