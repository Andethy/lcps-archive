package array;

/**
 * <a href="https://leetcode.com/problems/next-permutation">Next Permutation</a>
 */
class Solution31 {
    public void nextPermutation(int[] nums) {
        int startSwap = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i+1]) {
                continue;
            } else {
                int temp = nums[i];
                int min = 101;
                int minIndex = -1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > temp && nums[j] <= min) {
                        min = nums[j];
                        minIndex = j;
                    }
                }
                nums[i] = min;
                nums[minIndex] = temp;
                startSwap = i + 1;
                break;
            }

        }
        // Case of sorted descending
        for (int i = 0; i < (nums.length - startSwap) / 2; i++) {
            int temp = nums[nums.length - (i + 1)];
            nums[nums.length - (i + 1)] = nums[i + startSwap];
            nums[i + startSwap] = temp;
        }

    }
}