package nc.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * Note: don't use string operations when you don't have to!
 */
class Solution76C {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }

        int defficiency = map.size(), left = 0, right = 0;
        int minStart = -1, minLength = s.length() + 1;
        char[] chars = s.toCharArray();

        while (right < chars.length) {
            if (map.containsKey(chars[right])) {
                int diff = map.get(chars[right]) + 1;
                map.put(chars[right], diff);
                if (diff == 0) {
                    defficiency--;
                }
            }
            right++;

            while (defficiency == 0) {
                if (right - left < minLength) {
                    minStart = left;
                    minLength = right - left;
                }

                char removed = chars[left++];
                if (map.containsKey(removed)) {
                    int diff = map.get(removed) - 1;
                    map.put(removed, diff);
                    if (diff == -1) {
                        defficiency++;
                    }
                }

            }
        }

        return minLength > s.length() ? "" : s.substring(minStart, minStart + minLength);

    }
}
