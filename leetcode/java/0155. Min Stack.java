package leetcode.java;

import java.util.Stack;

// Time Complexity: O(1) for all operations
// Space complexity: O(N)

class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;

    public MinStack() {
        this.main = new Stack<>();
        this.min = new Stack<>();
    }
    
    public void push(int val) {
        this.main.push(val);
        if (this.min.empty() ||val <= this.min.peek()) {
            this.min.push(val);
        } else {
            this.min.push(this.min.peek());
        }
    }
    
    public void pop() {
        this.min.pop();
        this.main.pop();
    }
    
    public int top() {
        return this.main.peek();
    }
    
    public int getMin() {
        return this.min.peek();
        
    }
}
