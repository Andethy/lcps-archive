package strings;

import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int start = 0;
        int max = 0;
        for (int n = 0; n < s.length(); n++) {
            while(set.contains(chars[n])) {
                set.remove(chars[start++]);
            }
            set.add(chars[n]);
            if (set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }
}

