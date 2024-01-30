package nc.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses">Valid Parentheses</a>
 */
class Solution20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        String opens = "([{";
        String closes = ")]}";

        for (char c : s.toCharArray()) {
            if (opens.indexOf(c) != -1) {
                stack.push(c);
            } else if (stack.size() == 0 || opens.indexOf(stack.pop()) != closes.indexOf(c)) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
