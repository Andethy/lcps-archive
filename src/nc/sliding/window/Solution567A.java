package nc.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">Permutation in String</a>
 * Note: bad solution
 */
class Solution567A {
    public boolean checkInclusion(String s1, String s2) {
        int sz = s1.length();
        if (sz > s2.length()) {
            return false;
        }

        Map<Character, Integer> sub = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int n = 0; n < sz; n++) {
            sub.merge(s1.charAt(n), 1, Integer::sum);
            window.merge(s2.charAt(n), 1, Integer::sum);
        }

        if (sub.equals(window)) {
            return true;
        }
        System.out.println(s2 + " | " + sz);
        for (int n = sz; n < s2.length(); n++) {
            window.merge(s2.charAt(n), 1, Integer::sum);
            char removeKey = s2.charAt(n - sz);
            int removeVal = window.get(removeKey);
            if (removeVal <= 1) {
                window.remove(removeKey);
            } else {
                window.put(removeKey, removeVal - 1);
            }

            if (sub.equals(window)) {
                return true;
            }
        }
        return false;
    }
}
