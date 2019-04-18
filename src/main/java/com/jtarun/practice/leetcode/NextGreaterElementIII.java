package com.jtarun.practice.leetcode;

import java.util.*;

/** 556
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same
 * digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists,
 * you need to return -1.
 *
 * Example 1:
 *
 * Input: 12
 * Output: 21
 */
public class NextGreaterElementIII {

    private static class Solution {
        public int nextGreaterElement(int n) {
            List<Integer> l = new ArrayList<>();

            while (n > 0) {
                l.add(n%10);
                n /= 10;
            }

            if (l.size() <= 1) return -1;

            Collections.reverse(l);
            int i = l.size() - 2;

            while (i >= 0 && l.get(i) >= l.get(i+1)) i--;
            if (i < 0) return -1;

            int j = l.size()-1;
            while (j > i && l.get(j) <= l.get(i)) j--;

            int t = l.get(i);
            l.set(i, l.get(j));
            l.set(j, t);

            // Can only reverse it here instead of sorting as numbers will be in decreasing order.
            Collections.sort(l.subList(i+1, l.size()));

            long res = 0;
            for (i = 0; i < l.size(); i++) res = res * 10 + l.get(i);
            if (res > Integer.MAX_VALUE) return -1;


            return (int)res;
        }
    }

}
