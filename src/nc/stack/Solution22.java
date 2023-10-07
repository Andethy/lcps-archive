package nc.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses">Generate Parentheses</a>
 */
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> strs = new ArrayList<>();
        helper(n, 0, 0, "", strs);
        return strs;
    }

    private void helper(int max, int oCount, int cCount, String str, List<String> list) {
        if (oCount + cCount == 2 * max) {
            list.add(str);
        } else {
            if (oCount < max) {
                helper(max, oCount + 1, cCount, str + "(", list);
            }
            if (cCount < oCount) {
                helper(max, oCount, cCount + 1, str + ")", list);
            }
        }
    }
}
