package com.jtarun.practice.leetcode;

import java.util.*;

/** 528
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 */
public class RandomPickWithWeight {

    private static class Solution {
        int[] sum;
        Random rand;

        public Solution(int[] w) {
            sum = new int[w.length];
            sum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                sum[i] = sum[i-1] + w[i];
            }
            rand = new Random();
        }

        public int pickIndex() {
            int pick = rand.nextInt(sum[sum.length-1])+1;
            int ind = Arrays.binarySearch(sum, pick);
            if (ind < 0) ind = -(ind+1);
            return ind;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

}
