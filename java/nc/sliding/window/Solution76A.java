package nc.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring">Minimum Window Substring</a>
 * Note: brute force solution - first attempt - very bad
 */
class Solution76A {
    public String minWindow(String s, String t) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            set.add(ch);
            map.merge(ch, -1, Integer::sum);
        }

        int left = 0, right = 0;
        String minSub = s + " ";
        char[] sc = s.toCharArray();

        while (right < s.length()) {
            map.merge(sc[right++], 1, Integer::sum);


            while (right - left > minSub.length()) {
                map.merge(sc[left++], -1, Integer::sum);
            }

            boolean flag = true;
            while (flag) {
                // System.out.println("Checking: " + left + " | " + right);
                for (Character ch : set) {
                    // System.out.println("--"+ch+" | "+map.get(ch));
                    if (map.get(ch) < 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    // System.out.println("Valid: " + left + " | " + right);
                    String tempSub = s.substring(left, right);
                    if (tempSub.length() < minSub.length()) {
                        minSub = tempSub;
                    }
                    map.merge(sc[left++], -1, Integer::sum);
                }


            }
        }
        return minSub.length() > s.length() ? "" : minSub;
    }
}