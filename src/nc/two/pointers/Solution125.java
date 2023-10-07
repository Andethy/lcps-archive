package nc.two.pointers;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome">Valid Palindrome</a>
 */
class Solution125 {
    public boolean isPalindrome(String s) {
        int front = 0;
        int back = s.length() - 1;
        while (front < back) {
            char fChar = s.charAt(front);
            while((fChar < 'a' || fChar > 'z') && (fChar < '0' || fChar > '9')) {
                if (fChar >= 'A' && fChar <= 'Z') {
                    fChar = (char)((int)fChar + 32);
                    break;
                } else if (front == s.length() - 1) {
                    fChar = ' ';
                    break;
                }
                fChar = s.charAt(++front);
            }

            char bChar = s.charAt(back);
            while((bChar < 'a' || bChar > 'z') && (bChar < '0' || bChar > '9')) {
                if (bChar >= 'A' && bChar <= 'Z') {
                    bChar = (char)((int) bChar + 32);
                    break;
                } else if (back == 0) {
                    bChar = ' ';
                    break;
                }
                bChar = s.charAt(--back);
            }
            if (fChar != bChar) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
