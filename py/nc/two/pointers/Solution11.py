from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        out = 0
        while left < right:
            temp = min(height[left], height[right]) * (right - left)
            out = max(out, temp)
            if (height[left] < height[right]):
                left += 1
            else:
                right -= 1
        return out