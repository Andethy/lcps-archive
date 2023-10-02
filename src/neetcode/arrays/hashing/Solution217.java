package neetcode.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
 */
class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}