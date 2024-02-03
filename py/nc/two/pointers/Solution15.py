from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        out = []
        for a in range(len(nums) - 2):
            if nums[a] > 0:
                break

            if a > 0 and nums[a] == nums[a - 1]:
                continue

            b = a + 1
            c = len(nums) - 1
            while b < c:
                res = nums[a] + nums[b] + nums[c]
                if res < 0:
                    b += 1
                elif res > 0:
                    c -= 1
                else:
                    out.append([nums[a], nums[b], nums[c]])
                    b += 1
                    c -= 1
                    while b < c and nums[b] == nums[b - 1]:
                        b += 1
                    while b < c and nums[c] == nums[c + 1]:
                        c -= 1
        return out