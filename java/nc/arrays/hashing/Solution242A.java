package nc.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

class Solution242A {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int n = 0; n < s.length(); n++) {
            Character sc = s.charAt(n);
            Character tc = t.charAt(n);
            Integer sg = sMap.get(sc);
            Integer tg = tMap.get(tc);
            sMap.put(sc, sg == null ? 1 : sg + 1);
            tMap.put(tc, tg == null ? 1 : tg + 1);
        }
        return sMap.equals(tMap);
    }
}
