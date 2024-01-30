package nc.sliding.window;

import java.util.HashMap;
import java.util.Map;

class Solution76B {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.merge(ch, -1, Integer::sum);
        }

        int defficiency = map.size(), left = 0, right = 0;
        String minSub = s + " ";
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
                if (right - left < minSub.length()) {
                    minSub = s.substring(left, right);
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

        return minSub.length() > s.length() ? "" : minSub;

    }
}
