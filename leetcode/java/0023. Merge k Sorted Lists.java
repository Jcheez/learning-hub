package leetcode.java;

import java.util.LinkedList;
import java.util.Queue;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Time complexity: O(kN), where k is the number of linked lists and N is the total number of nodes in lists
// Space complexity: O(N)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> q = new LinkedList<>();
        for (ListNode l : lists) {
            q.add(l);
        }

        while (q.size() > 1) {
            ListNode l1 = q.poll();
            ListNode l2 = q.poll();
            q.add(this.merge(l1, l2));
        }

        return q.poll();
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = new ListNode(l1.val);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = new ListNode(l2.val);
            l2 = l2.next;
            temp = temp.next;
        }
        return res.next;
    }
}