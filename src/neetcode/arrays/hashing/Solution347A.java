package neetcode.arrays.hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/description/">Top K Frequent Elements</a>
 * Note: bad solution.
 */
class Solution347A {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        Integer[][] kvp = new Integer[map.size()][2];
        int curr = 0;
        for (Integer key : map.keySet()) {
            kvp[curr++] = new Integer[]{map.get(key), key};
        }

        Arrays.sort(kvp, Comparator.comparingInt(arr -> arr[0]));
        int[] finalArray = new int[k];
        for (int n = 0; n < k; n++) {
            finalArray[n] = kvp[kvp.length - n - 1][1];
        }
        return finalArray;
    }
}
