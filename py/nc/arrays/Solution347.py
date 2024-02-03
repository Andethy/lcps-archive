import collections
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        mapping = collections.defaultdict(int)
        buckets = [[] for _ in range(len(nums) + 1)]
        for num in nums:
            mapping[num] += 1
        for key, val in mapping.items():
            buckets[val].append(key)
        res = []
        for bucket in buckets[::-1]:
            for item in bucket:
                res.append(item)
                if len(res) == k:
                    return res


