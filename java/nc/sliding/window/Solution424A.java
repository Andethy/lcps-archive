package nc.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">Longest Repeating Character Replacement</a>
 */
class Solution424A {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>(27, 1.0f);
        int left = 0, right = 0, maxOccurrence = 0, maxTotal = 0;
        while (right < s.length()) {
            char curr = s.charAt(right++);
            map.merge(curr, 1, Integer::sum);
            maxOccurrence = Math.max(map.get(curr), maxOccurrence);
            while (right - left - maxOccurrence > k) {
                map.merge(s.charAt(left++), -1, Integer::sum);
            }
            maxTotal = Math.max(right - left, maxTotal);
        }
        return maxTotal;
    }
}

