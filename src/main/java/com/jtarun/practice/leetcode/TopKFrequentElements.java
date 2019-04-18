package com.jtarun.practice.leetcode;

import java.util.*;

/** 347
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {

    private static class Solution {

        // O(n) solution. Bucketsort on frequency
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> h = new HashMap<>();
            for (int num : nums) {
                h.put(num, h.getOrDefault(num, 0)+1);
            }

            List<Integer>[] buckets = new List[nums.length+1];
            for (Map.Entry<Integer, Integer> e : h.entrySet()) {
                int freq = e.getValue();
                int num = e.getKey();
                if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
                buckets[freq].add(num);
            }

            List<Integer> res = new ArrayList<>();
            int freq = nums.length;
            while (k > 0) {
                if (buckets[freq] != null) {
                    // The answer has to be unique for this step, otherwise just add sufficient elements only.
                    res.addAll(buckets[freq]);
                    k -= buckets[freq].size();
                }
                freq--;
            }

            return res;
        }

        // O(nlogn) solution
        public List<Integer> topKFrequent2(int[] nums, int k) {
            List<Integer> l = new ArrayList<>();

            Map<Integer, Integer> h = new HashMap<>();
            for (int num : nums) {
                h.put(num, h.getOrDefault(num, 0)+1);
            }


            TreeSet<int[]> s = new TreeSet<>((a, b) -> (b[1] == a[1]) ? -1 : b[1] - a[1]);
            for (Map.Entry<Integer, Integer> e : h.entrySet()) {
                s.add(new int[]{e.getKey(), e.getValue()});
            }

            while(!s.isEmpty() && k-- > 0) {
                l.add(s.pollFirst()[0]);
            }

            return l;
        }
    }

}
