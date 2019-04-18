package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 401
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent
 * the minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the right.
 */
public class BinaryWatch {
    private static class Solution {
        public List<String> readBinaryWatch(int n) {
            List<String> res = new ArrayList<>();

            Map<Integer, List<Integer>> h = new HashMap<>();
            Map<Integer, List<Integer>> g = new HashMap<>();

            for (int i = 0; i <= 59; i++) {
                int cnt = count(i);
                if (i <= 11){
                    h.computeIfAbsent(cnt, k -> new ArrayList<>()).add(i);
                }
                g.computeIfAbsent(cnt, k -> new ArrayList<>()).add(i);
            }

            for (int i = 0; i <= Math.min(4, n); i++) {
                int j = n - i;
                if ( j > 6) {
                    continue;
                }

                List<Integer> x = h.get(i);
                List<Integer> y = g.get(j);

                if (x == null || y == null) {
                    continue;
                }

                for (int l = 0; l < x.size(); l++) {
                    for (int m = 0; m < y.size(); m++) {
                        res.add(x.get(l) + ":" + prefix(y.get(m)));
                    }
                }
            }


            return res;
        }

        private String prefix(int n) {
            String res = "";
            if (n <= 9) {
                res += "0";
            }
            res += n;
            return res;
        }

        private int count(int n) {
            int cnt = 0;
            while (n != 0) {
                n =n & (n-1);
                cnt++;
            }
            return cnt;
        }

    }
}
