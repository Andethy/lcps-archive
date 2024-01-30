package nc.binary.search;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array">Find Minimum in Rotated Sorted Array</a>
 */
class Solution153 {
    public int findMin(int[] nums) {
        return rotatedSearch(nums, 0, nums.length - 1);
    }

    private int rotatedSearch(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) {
            return nums[start];
        }

        int mid = (start + end) / 2;
        if (nums[mid] >= nums[start]) {
            return rotatedSearch(nums, mid + 1, end);
        }  else {
            return rotatedSearch(nums, start, mid);
        }

    }
}