package strings;

/**
 * <a href="https://leetcode.com/problems/length-of-last-word/description/">Length of Last Word</a>
 */
class Solution58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(s.charAt(end) == ' ') {
            end--;
        }
        int start = end - 1;
        while(start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }
}
