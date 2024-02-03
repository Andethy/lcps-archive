class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        d1, d2 = {}, {}
        for c1, c2 in zip(s, t):
            d1[c1] = d1.get(c1, 0) + 1
            d2[c2] = d2.get(c2, 0) + 1
        return d1 == d2
