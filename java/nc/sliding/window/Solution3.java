package nc.sliding.window;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Longest Substring Without Repeating Characters</a>
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int curr = 0;
        for (int n = 0; n < chars.length; n++) {
            while (set.contains(chars[n])) {
                set.remove(chars[curr++]);
            }
            set.add(chars[n]);
            if (set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }
}
