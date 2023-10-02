package neetcode.arrays.hashing;

import java.util.Arrays;

public class Solution242B {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[26];
        for (int n = 0; n < s.length(); n++) {
            chars[(int) s.charAt(n) - 97]++;
            chars[(int) t.charAt(n) - 97]--;

        }
        return Arrays.equals(chars, new int[26]);
    }
}
