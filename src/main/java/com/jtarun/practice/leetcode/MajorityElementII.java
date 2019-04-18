package com.jtarun.practice.leetcode;

import java.util.*;

/** 229
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 */
public class MajorityElementII {

    private static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> h = new HashMap<>();

            for (int num : nums) {
                if (h.containsKey(num)) {
                    h.put(num, h.get(num) + 1);
                } else if (h.size() < 2) {
                    h.put(num, 1);
                } else {
                    List<Integer> remove = new ArrayList<>();
                    for (int key : h.keySet()) {
                        h.put(key, h.get(key)-1);
                        if (h.get(key) == 0) remove.add(key);
                    }
                    h.keySet().removeAll(remove);
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int x : h.keySet()) {
                int cnt = 0;
                for (int num : nums) {
                    if (num == x) cnt++;
                }

                if (cnt > n/3) res.add(x);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.majorityElement(new int[]{4,2,1,1}).forEach(System.out::println);
    }

}
