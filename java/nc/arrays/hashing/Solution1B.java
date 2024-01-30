package nc.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

class Solution1B {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            int dif = target - nums[n];
            if (map.containsKey(dif)) {
                return new int[]{n, map.get(dif)};
            } else {
                map.put(nums[n], n);
            }
        }
        return null;
    }
}