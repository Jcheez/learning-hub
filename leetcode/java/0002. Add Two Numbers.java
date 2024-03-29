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
// Space complexity: O(N)

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;

        int carry = 0;

        while(l1 != null || l2 != null) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 =l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(sum%10);
            temp = temp.next;
            carry = sum / 10;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }

        return res.next;
    }
}