package com.jtarun.practice.leetcode;

import java.util.*;

/** 373
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second
 * array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 */
public class FindKPairsWithSmallestSums {

    private static class Solution {

        // O(klogk)
        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            int m = nums2.length;
            if (k == 0 || n == 0 || m == 0) return new ArrayList<>();

            Comparator<int[]> cmp = (a, b) -> {
                int sum1 = a[0], sum2 = b[0];
                int c = sum1 - sum2;
                if (c == 0) c = -1;
                return c;
            };
            PriorityQueue<int[]> pq = new PriorityQueue(k, cmp);
            for (int i = 0; i < Math.min(k, n); i++) {
                pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
            }

            List<int[]> res = new ArrayList<>();
            while (res.size() < k && !pq.isEmpty()) {
                int[] top = pq.poll();
                int sum = top[0], i = top[1], j = top[2];
                res.add(new int[]{nums1[i], nums2[j]});
                if (j < m-1) pq.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
            }
            return res;
        }


        // O(mnlogk)
        public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
            if (k == 0) return new ArrayList<>();

            Comparator<int[]> cmp = (a, b)-> {
                int sum1 = a[1] + a[0];
                int sum2 = b[1] + b[0];
                int c = sum2 - sum1;
                if (c == 0) c = -1;
                return c;
            };

            TreeSet<int[]> h = new TreeSet<>(cmp);

            for (int i = 0; i < Math.min(k,nums1.length); i++) {
                for (int j = 0; j < Math.min(k, nums2.length); j++) {
                    if (h.size() < k) {
                        h.add(new int[]{nums1[i], nums2[j]});
                    } else if (h.size() == k) {
                        int[] max = h.first();
                        int maxSum = max[0] + max[1];
                        if (nums1[i] + nums2[j] < maxSum) {
                            h.pollFirst();
                            h.add(new int[]{nums1[i], nums2[j]});
                        }
                    }

                }
            }

            List<int[]> res = new ArrayList<>();
            while (!h.isEmpty()) {
                res.add(h.pollFirst());
            }

            Collections.reverse(res);
            return res;
        }
    }

}
