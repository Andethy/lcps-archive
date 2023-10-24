package nc.sliding.window;

import java.util.Arrays;

class Solution567B {
    public boolean checkInclusion(String s1, String s2) {
        int sz = s1.length();
        if (sz > s2.length()) {
            return false;
        }

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int n = 0; n < sz; n++) {
            c1[s1.charAt(n) - 'a']++;
            c2[s2.charAt(n) - 'a']++;
        }



        for (int n = sz; n < s2.length(); n++) {
            if (Arrays.equals(c1, c2)) {
                return true;
            }
            c2[s2.charAt(n) - 'a']++;
            c2[s2.charAt(n - sz) - 'a']--;
        }

        return Arrays.equals(c1, c2);
    }
}
