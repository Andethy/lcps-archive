package nc.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Note: much better solution
 */
class Solution15B {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 1; a++) {
            if (a > 0 && nums[a] == nums[a-1]) {
                continue;
            }
            int b = a + 1;
            int c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum > 0) {
                    c--;
                } else if (sum < 0) {
                    b++;
                } else {
                    list.add(List.of(nums[a], nums[b], nums[c]));
                    b++;
                    c--;
                    while (b < c && nums[b] == nums[b - 1]) {
                        b++;
                    }
                    while (c > b && nums[c] == nums[c + 1]) {
                        c--;
                    }
                }
            }
        }
        return list;
    }
}

