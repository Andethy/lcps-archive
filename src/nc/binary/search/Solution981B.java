package nc.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution981B {
    class TimeMap {
        private class Entry {
            public String value;
            public int time;

            public Entry(String value, int time) {
                this.value = value;
                this.time = time;
            }
        }

        Map<String, List<Entry>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Entry(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Entry> list = map.get(key);
            String value = "";
            int start = 0;
            int end = list == null ? -1 : list.size() - 1;
            int mid = -1 ;
            while (start <= end) {
                mid = (start + end) / 2;
                Entry curr = list.get(mid);
                if (curr.time <= timestamp) {
                    start = mid + 1;
                    value = curr.value;
                } else {
                    end = mid - 1;
                }
            }

            return value;
        }

    }
}
