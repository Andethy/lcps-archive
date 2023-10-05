package neetcode.arrays.hashing;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 */
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] subs = new HashSet[9];

        for (int n = 0; n < 9; n++) {
            rows[n] = new HashSet<>();
            cols[n] = new HashSet<>();
            subs[n] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int sub = (c / 3 + 1) + 3 * (r / 3) - 1;
                Character ch = board[r][c];
                if (ch.equals('.')) {
                    continue;
                } else if (!rows[r].add(ch) || !cols[c].add(ch) || !subs[sub].add(ch)) {
                    return false;
                }
            }
        }
        return true;
    }
}
