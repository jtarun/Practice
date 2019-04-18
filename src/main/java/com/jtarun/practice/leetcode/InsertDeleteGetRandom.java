package com.jtarun.practice.leetcode;

import java.util.*;

/** 380
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability
 * of being returned.
 */
public class InsertDeleteGetRandom {

    private static class RandomizedSet {

        Map<Integer, Integer> h = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        Random random = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (h.containsKey(val)) return false;

            l.add(val);
            h.put(val, l.size()-1);

            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!h.containsKey(val)) return false;

            int ind = h.get(val);
            if (ind != l.size()-1) {
                int key = l.get(l.size()-1);
                l.set(ind, key);
                h.put(key, ind);
            }
            h.remove(val);
            l.remove(l.size()-1);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int n = random.nextInt(l.size());
            return l.get(n);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
