package com.jtarun.practice.leetcode;

import java.util.*;

/** 128
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {

    private static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> s = new HashSet<>();
            for (int n : nums)s.add(n);

            int res = 0;
            for (int n : s) {
                if (!s.contains(n-1)) {
                    int cnt = 1;
                    int x = n+1;
                    while (s.contains(x)) {
                        cnt++;
                        x++;
                    }
                    res = Math.max(res, cnt);
                }

            }

            return res;
        }
    }

}
