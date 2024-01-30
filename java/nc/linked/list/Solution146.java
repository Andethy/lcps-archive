package nc.linked.list;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    static class LRUCache {
        private CacheNode head;
        private CacheNode tail;

        private int capacity;
        private int size;

        private Map<Integer, CacheNode> backingMap;

        private class CacheNode {
            public int key;
            public int value;
            public CacheNode next;
            public CacheNode prev;

            public CacheNode(int k, int v) {
                this(k, v, null, null);
            }

            public CacheNode(int k, int v, CacheNode n, CacheNode p) {
                key = k;
                value = v;
                next = n;
                prev = p;
            }

            public String toString() {
                return "{" + key + ":" + value + "}";
            }

        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            backingMap = new HashMap<>();
        }

        public int get(int key) {
            if (backingMap.containsKey(key)) {
                moveToFront(key);
                return head.value;
            }
            return -1;
        }

        private void moveToFront(int key) {
            CacheNode toAdd = backingMap.get(key);
            if (toAdd == head) {
                return;
            }

            if (toAdd.prev != null) {
                toAdd.prev.next = toAdd.next;
            }
            if (toAdd.next != null) {
                toAdd.next.prev = toAdd.prev;
            }

            if (toAdd == tail) {
                tail = tail.prev;
            }

            toAdd.next = head;

            head = toAdd;
            if (size > 1) {
                head.next.prev = head;
            }
        }

        public void put(int key, int value) {
            if (backingMap.containsKey(key)) {
                moveToFront(key);
                head.value = value;
            } else {
                if (size == capacity) {
                    backingMap.remove(tail.key);
                    tail = tail.prev;
                    if (size-- > 1) {
                        tail.next = null;
                    }

                }

                head = new CacheNode(key, value, head, null);
                if (size == 0) {
                    tail = head;
                } else {
                    head.next.prev = head;
                }

                backingMap.put(key, head);
                size++;
            }

        }
    }
}
