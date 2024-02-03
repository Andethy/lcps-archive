from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        targets = {}
        for index, num in enumerate(nums):
            if target - num in targets:
                return [targets[target - num], index]
            targets[num] = index
