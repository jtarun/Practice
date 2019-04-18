package com.jtarun.practice.leetcode;


public class GuessNumberHigherOrLowerII {

    private static class Solution {
        public int getMoneyAmount(int n) {
            if (n == 1) return 0;
            int lo = 1, hi = n;

            int res = 0;
            while (lo < hi) {
                int mid = lo + (hi - lo)/2;
                System.out.println(mid+ " ");
                res += mid;

                int left = mid-lo;
                int right = hi-mid;

                if (left > right) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }

            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getMoneyAmount(4));
    }
}
