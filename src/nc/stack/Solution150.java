package nc.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation">Evaluate Reverse Polish Notation</a>
 */
class Solution150 {
    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int b = stack.pop(), a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
