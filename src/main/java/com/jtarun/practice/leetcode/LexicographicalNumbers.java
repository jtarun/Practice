package com.jtarun.practice.leetcode;

import java.util.*;

/** 386
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class LexicographicalNumbers {

    private static class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            helper(0, n,res);
            return res;
        }

        private void helper(int x, int n, List<Integer> res) {

            for (int i = 0; i < 10; i++) {
                int t = x*10+i;
                if (t > 0 && t <= n) {
                    res.add(t);
                    helper(t, n, res);
                }
            }

        }

    }

}
