package leetcode.java;

import java.util.Stack;

class MyQueue {

    public Stack<Integer> s1;
    public Stack<Integer> s2;

    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        this.s1.push(x);
    }
    
    public int pop() {
        if (this.s2.size() == 0) {
            while (this.s1.size() > 1) {
                this.s2.add(this.s1.pop());
            }
            return this.s1.pop();
        } else {
            return this.s2.pop();
        }
    }
    
    public int peek() {
        if (this.s2.size() == 0) {
            while (this.s1.size() > 0) {
                this.s2.add(this.s1.pop());
            }
            return this.s1.peek();
        }
        return this.s2.peek();
    }
    
    public boolean empty() {
        return this.s1.size() == 0 && this.s2.size() == 0;
    }
}
