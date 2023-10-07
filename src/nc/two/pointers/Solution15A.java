package nc.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/3sum">3Sum</a>
 * Note: bad solution
 */
class Solution15A {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int a = 0; a < nums.length - 1; a++) {
            int b = a + 1;
            int c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum > 0) {
                    c--;
                } else if (sum < 0) {
                    b++;
                } else {
                    List<Integer> validSum = List.of(nums[a], nums[b], nums[c]);
                    if (set.add(validSum)) {
                        list.add(validSum);
                    }
                    b++;
                    c--;
                }
            }
        }
        return list;
    }
}

