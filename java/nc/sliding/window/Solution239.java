package nc.sliding.window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum">Sliding Window Maximum</a>
 */
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> storage = new ArrayDeque<>();

        for (int n = 0; n < k - 1; n++) {
            while (!storage.isEmpty() && storage.getLast() < nums[n]) {
                storage.removeLast();
            }
            storage.addLast(nums[n]);
        }

        for (int n = 0; n < result.length; n++) {
            while (!storage.isEmpty() && storage.getLast() < nums[n + k - 1]) {
                storage.removeLast();
            }
            storage.addLast(nums[n + k - 1]);
            result[n] = storage.getFirst();
            if (nums[n] == result[n]) {
                storage.removeFirst();
            }
        }

        return result;
    }
}
