from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = [1] * len(nums)
        left_prod = 1
        right_prod = 1
        for n in range(1, len(nums)):
            left_prod *= nums[n - 1]
            right_prod *= nums[len(nums) - n]
            output[n] *= left_prod
            output[len(nums) - n - 1] *= right_prod
        return output
