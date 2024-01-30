package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">Letter Combinations of a Phone Number</a>
 * Haven't learned graph algorithms yet lol
 **/
class Solution17A {
    //TODO: Solution B upon getting better at BFS/DFS
    private int[] offsets = new int[]{97, 100, 103, 106, 109, 112, 116, 119, 123};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        int s = digits.length();
        if (s == 0) {
            return list;
        }
        int[] digs = new int[s];
        int iterations = 1;
        for (int i = 0; i < s; i++) {
            int toAdd = 0;
            digs[i] = Integer.parseInt(digits.substring(i, i+1)) - 2;
            iterations *= getDif(digs[i]);
        }

        for (int i = 0; i < iterations; i++) {
            String combo = "";
            int divisor = iterations / getDif(digs[0]);
            for (int j = 0; j < s; j++) {
                int n = (int) (i / divisor) % getDif(digs[j]);
                combo += (char) (offsets[digs[j]] + n);
                if (j < s - 1) {
                    divisor /= getDif(digs[j + 1]);
                }

            }
            list.add(combo);
        }
        return list;
    }



    private int getDif(int dig) {
        return offsets[dig + 1] - offsets[dig];
    }
}