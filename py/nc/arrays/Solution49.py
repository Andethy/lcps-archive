import collections
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        lookup = collections.defaultdict(list)
        for string in strs:
            temp = [0] * 26
            for char in string:
                temp[ord(char) - 97] += 1
            temp = tuple(temp)
            lookup[temp].append(string)
        return lookup.values()