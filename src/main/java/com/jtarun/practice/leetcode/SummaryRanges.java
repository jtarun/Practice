package com.jtarun.practice.leetcode;

import java.util.*;

/** 228
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class SummaryRanges {

    private static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            int i = 0, n = nums.length;
            while ( i < n) {
                int j = i+1;
                while (j < n && (nums[j] - nums[j-1] == 1)) j++;
                int len = j-i;
                if (len == 1) {
                    res.add(""+nums[i]);
                } else {
                    res.add(nums[i] + "->" + nums[j-1]);
                }

                i = j;
            }

            return res;
        }
    }

}
