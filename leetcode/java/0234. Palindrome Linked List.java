package leetcode.java;

import java.util.Stack;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode temp = head;
        Stack<Integer> s = new Stack<>();

        while (temp != null) {
            temp = temp.next;
            length += 1;
        }

        int toKeep = length / 2;

        while (toKeep > 0) {
            s.push(head.val);
            head = head.next;
            toKeep -= 1;
        }

        if (length % 2 != 0) {
            head = head.next;
        }

        while (head != null) {
            if (head.val != s.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}