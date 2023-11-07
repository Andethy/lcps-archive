package nc.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/time-based-key-value-store">Time Based Key-Value Store</a>
 */
public class Solution981A {
    class TimeMap {
        private class CustomEntry<K, V> {
            public K key;
            public V val;

            CustomEntry(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        HashMap<String, List<CustomEntry<String, Integer>>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new CustomEntry<>(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<CustomEntry<String, Integer>> list = map.get(key);
            String toReturn = "";
            return list == null ? "" : binarySearch(list, timestamp, 0, list.size() - 1);
        }

        private String binarySearch(List<CustomEntry<String, Integer>> list, int target, int front, int back) {
            if (front > back) {
                return front == 0 ? "" : list.get(front - 1).key;
            }
            int mid = (front + back) / 2;
            CustomEntry<String, Integer> midEntry = list.get(mid);
            if (midEntry.val == target) {
                return midEntry.key;
            } else if (midEntry.val > target) {
                return binarySearch(list, target, front, mid - 1);
            } else {
                return binarySearch(list, target, mid + 1, back);
            }
        }
    }
}
