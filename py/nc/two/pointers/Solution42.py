from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        max_left, max_right = height[0], height[-1]
        total = 0
        while left < right:
            if height[left] < height[right]:
                total += min(max_left, max_right) - height[left]
                left += 1
                max_left = max(max_left, height[left])
            else:
                total += min(max_left, max_right) - height[right]
                right -= 1
                max_right = max(max_right, height[right])
        return total