package nc.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence">Longest Consecutive Sequence</a>
 */
class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }

        int max = 0;
        for (int num : nums) {
            int count = 1;
            if (hash.contains(num - count)) {
                continue;
            }
            while (hash.contains(num + count)) {
                count++;
            }
            max = Math.max(max, count);
            // CRUCIAL for runtime
            if (max > nums.length / 2) {
                break;
            }
        }
        return max;
    }
}