package com.jtarun.practice.leetcode;

/** 706
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap,
 * update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 */
public class DesignHashMap {

    private static class MyHashMap {
        private static class Node {
            int key;
            int value;
            Node next;

            Node (int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int BUCKET_SIZE = 100000;
        Node[] buckets = new Node[BUCKET_SIZE];

        /** Initialize your data structure here. */
        public MyHashMap() {

        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int ind = idx(key);
            if (buckets[ind] == null) {
                buckets[ind] = new Node(key, value);
            } else {
                Node t = buckets[ind];
                while (t.next != null && t.key != key) {
                    t = t.next;
                }

                if (t.key == key) {
                    t.value = value;
                } else {
                    t.next = new Node(key, value);
                }
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int ind = idx(key);
            Node t = buckets[ind];

            while (t != null) {
                if (t.key == key) return t.value;
                t = t.next;
            }

            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int ind = idx(key);
            Node t = buckets[ind], prev = null;
            while (t != null) {
                if (t.key == key) {
                    if (prev == null) {
                        buckets[ind] = t.next;
                    } else {
                        prev.next = t.next;
                    }
                    break;
                }
                prev = t;
                t = t.next;
            }
        }

        private int idx(int key) {
            return Integer.hashCode(key) % BUCKET_SIZE;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

}
