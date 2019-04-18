package com.jtarun.practice.leetcode;

import java.util.*;

/** 381
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element
 * being returned is linearly related to the number of same value the collection contains.
 */
public class InsertDeleteGetRandomDuplicatesAllowed {

    private static class RandomizedCollection {

        Map<Integer, Set<Integer>> h = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        Random random = new Random();

        /** Initialize your data structure here. */
        public RandomizedCollection() {

        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean res = false;
            if (!h.containsKey(val)) {
                h.put(val, new HashSet<>());
                res = true;
            }

            l.add(val);
            h.get(val).add(l.size()-1);

            return res;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            boolean res = false;

            if (h.containsKey(val)) {
                res = true;

                Set<Integer> indSet = h.get(val);
                int ind = indSet.iterator().next();

                if (ind != l.size()-1 && (l.get(l.size()-1) == val)) {
                    ind = l.size()-1;
                } else if (ind != l.size()-1) {
                    int lastVal = l.get(l.size()-1);
                    l.set(ind, lastVal);
                    Set<Integer> lastValIndices = h.get(lastVal);
                    lastValIndices.remove(l.size()-1);
                    lastValIndices.add(ind);
                }
                l.remove(l.size()-1);

                indSet.remove(ind);
                if (indSet.isEmpty()) {
                    h.remove(val);
                }
            }

            return res;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int ind = random.nextInt(l.size());
            return l.get(ind);
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
