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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode temp = res;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            temp = temp.next;
        }

        while (list1 != null) {
            temp.next = new ListNode(list1.val);
            list1 = list1.next;
            temp = temp.next;
        }

        while (list2 != null) {
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }

        return res.next;
    }
}