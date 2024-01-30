package nc.arrays.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution347B {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] arr = new ArrayList[nums.length + 1];
        for (int num : nums) {
            map.merge(num, 1, (oldVal, newVal) -> (oldVal + 1));
        }

        for (Integer key : map.keySet()) {
            Integer index = map.get(key);
            if(arr[index] == null) {
                arr[index] = new ArrayList<>();
            }
            arr[index].add(key);
        }
        int[] toReturn = new int[k];
        int counter = 0;
        int curr = arr.length;
        while (counter < k) {
            if (arr[--curr] != null) {
                for (int num : arr[curr]) {
                    toReturn[counter++] = num;
                }
            }
        }

        return toReturn;
    }
}
