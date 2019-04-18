package com.jtarun.practice.leetcode;

/** 705
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 */
public class DesignHashSet {

    private static class MyHashSet {
        private class Node {
            int val;
            Node next;
            Node(int key) {
                this.val = key;
            }
        }

        int BUCKET_SIZE = 100000;
        Node[] buckets = new Node[BUCKET_SIZE];

        /** Initialize your data structure here. */
        public MyHashSet() {
        }

        public void add(int key) {
            int ind = idx(key);
            Node n = new Node(key);
            if (buckets[ind] == null) buckets[ind] = n;
            else {
                Node head = buckets[ind];
                while (head.next != null && head.val != key) {
                    head = head.next;
                }
                if (head.val != key) head.next = n;
            }
        }

        public void remove(int key) {
            int ind = idx(key);

            Node t = buckets[ind], prev = null;
            while (t != null) {
                if (t.val == key) {
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

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int ind = idx(key);

            Node t = buckets[ind];
            while (t != null) {
                if (t.val == key) return true;
                t = t.next;
            }
            return false;
        }

        private int idx(int key) {
            return Integer.hashCode(key) % BUCKET_SIZE;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

}
