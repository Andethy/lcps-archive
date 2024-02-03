class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        vals = set(nums)
        seq = 0

        for num in nums:
            count = 1

            if num - 1 in vals:
                continue

            while num + count in vals:
                count += 1

            seq = max(seq, count)

        return seq