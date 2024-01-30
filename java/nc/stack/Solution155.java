package nc.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/min-stack">Min Stack</a>
 */
class Solution155 {
    class MinStack {
        Stack<Integer> backingStack;
        Stack<Integer> minStack;

        public MinStack() {
            backingStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            backingStack.push(val);
            minStack.push(Math.min(val, minStack.size() > 0 ? getMin() : val));
        }

        public void pop() {
            backingStack.pop();
            minStack.pop();
        }

        public int top() {
            return backingStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
