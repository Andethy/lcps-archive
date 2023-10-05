package neetcode.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures">Daily Temperatures</a>
 */
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Stack<Integer> idxs = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!idxs.isEmpty() && temperatures[idxs.peek()] < temperatures[i]) {
                int prevIdx = idxs.pop();
                days[prevIdx] = i - prevIdx;
            }
            idxs.add(i);
        }
        return days;
    }
}
