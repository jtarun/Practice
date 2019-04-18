package com.jtarun.practice.leetcode;

import java.util.*;

/** 397
 * Given a positive integer n and you can do operations as follow:
 *
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 * Example 1:
 *
 * Input:
 * 8
 *
 * Output:
 * 3
 */
public class IntegerReplacement {

    private static class Solution {

        public int integerReplacement1(int r) {
            if (r <= 1) return 0;

            int res = 0;
            long n = r;
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n >>> 1;
                } else if (n == 3 || ((n & 3) == 1)) {
                    n--;
                } else n++;
                res++;
            }

            return res;
        }


        public int integerReplacement(int n) {
            if (n == 1) return 0;

            if (n == 1) return 0;

            if (n % 2 == 0) {
                return 1 + integerReplacement(n/2);
            }

            if (n == Integer.MAX_VALUE) {
                return Math.min(integerReplacement(n-1)+1, integerReplacement((n-1) / 2 + 1) + 2);
            }

            return Math.min(integerReplacement(n-1), integerReplacement(n+1)) + 1;
        }


        public int integerReplacement2(int n) {
            if (n <= 1) return 0;

            // If n == Integer.MAX_VALUE, then we cannot add 1 to it as it overflows, hence long is used.
            Long val = new Long(n);
            Queue<Long> q = new LinkedList<>();
            q.offer(val);
            int level = 0;
            Set<Long> v = new HashSet<>();
            while (!q.isEmpty()) {
                level++;
                int cnt = q.size();
                while (cnt-- > 0) {
                    long t = q.poll();
                    if (t == 2) return level;

                    if (t %2 == 0) {
                        if (v.add(t/2)) q.offer(t/2);
                    } else {

                        if (v.add(t-1)) {
                            q.offer(t-1);
                        }

                        if (v.add(t+1)) {
                            q.offer(t+1);
                        }
                    }

                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.integerReplacement(Integer.MAX_VALUE));
    }

}
