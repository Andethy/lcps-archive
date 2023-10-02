package neetcode.arrays.hashing;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/submissions/">Product of Array Except Self</a>
 * Note: bad solution
 */
class Solution238A {
    public int[] productExceptSelf(int[] nums) {
        int sz = nums.length;
        int[] left = new int[sz];
        int[] right = new int[sz];
        left[0] = 1;
        right[sz - 1] = 1;
        for (int n = 1; n < sz; n++) {
            left[n] = left[n - 1] * nums[n - 1];
            right[sz - n - 1] = right[sz - n] * nums[sz - n];
        }

        for (int n = 0; n < sz; n++) {
            left[n] *= right[n];
        }

        return left;
    }
}