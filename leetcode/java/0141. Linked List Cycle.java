package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(1)

//Provided definition
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


class Solution {
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == Integer.MAX_VALUE) {
                return true;
            } else {
                head.val = Integer.MAX_VALUE;
            }
            head = head.next;
        }
        return false;
    }
}