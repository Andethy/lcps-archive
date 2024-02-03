from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        subs = [set() for _ in range(9)]
        for r in range(9):
            for c in range(9):
                t = board[r][c]
                if t == '.':
                    continue
                sub = (c // 3 + 1) + 3 * (r // 3) - 1
                if t in rows[r] or t in cols[c] or t in subs[sub]:
                    return False
                rows[r].add(t)
                cols[c].add(t)
                subs[sub].add(t)
        return True