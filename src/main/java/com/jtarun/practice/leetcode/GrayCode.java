package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 89
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 */
public class GrayCode {
    private static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            if ( n == 0) return res;
            res.add(1);
            if (n == 1) return res;

            for (int i = 2; i <= n; i++) {
                int l = res.size();

                for (int j = l-1; j >= 0; j--) {
                    int d = res.get(j);
                    int v = (1 << (i-1)) | d;
                    res.add(v);
                }
            }

            return res;
        }
    }
}
