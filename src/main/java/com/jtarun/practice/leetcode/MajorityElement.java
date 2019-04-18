package com.jtarun.practice.leetcode;


import java.util.HashMap;
import java.util.Map;

/** 169
 * Given an array of size n, find the majority element. The majority element is the element that appears more
 * than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    private static class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> h = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int mask = 0x1;
                for (int j = 0; j <= 31; j++) {
                    if ((mask & nums[i]) != 0) {
                        int cnt = h.getOrDefault(j, 0);
                        h.put(j, cnt+1);
                    }
                    mask <<= 1;
                }

            }

            int res = 0;
            int maj = nums.length / 2;
            for (int i = 0; i <= 31; i++) {
                int cnt = h.getOrDefault(i, 0);
                if (cnt > maj) {
                    res |= 1<<i;
                }
            }

            return res;
        }
    }
}
