package leetcode.java;

import java.util.Stack;

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (String t : tokens) {
            if (t.equals("+")) {
                int newNum = s.pop() + s.pop();
                s.push(newNum);
            } else if (t.equals("-")) {
                int num1 = s.pop();
                int num2 = s.pop();
                s.push(num2 - num1);
            } else if (t.equals("*")) {
                int newNum = s.pop() * s.pop();
                s.push(newNum);
            } else if (t.equals("/")) {
                int num1 = s.pop();
                int num2 = s.pop();
                s.push(num2 / num1);
            } else {
                s.push(Integer.parseInt(t));
            }
        }
        return s.pop();
    }
}