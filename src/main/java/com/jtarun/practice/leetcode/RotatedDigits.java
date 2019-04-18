package com.jtarun.practice.leetcode;

/** 788
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is
 * different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate
 * to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and
 * become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 */
public class RotatedDigits {

    private static class Solution {
        public int rotatedDigits(int N) {
            int d = 0;
            int n = N;
            while (n > 0) {
                d++;
                n = n/10;
            }

            int[] p = new int[]{0,1,8,2,5,6,9};
            int[] res = new int[1];
            helper(N, new int[d], 0, p, res);
            return res[0];
        }

        private void helper(int n, int[] d, int i, int[] p, int[] res) {
            if (i == d.length) return;

            for (int j = 0; j < p.length; j++) {
                if (i == 0 && p[j] == 0) continue;
                d[i] = p[j];
                boolean found = false;
                for (int k = 0; k <= i && !found; k++) {
                    if(d[k] == 2 || d[k] == 5 || d[k] == 6 || d[k] == 9) found = true;
                }
                int x = number(d, i);
                if (found && x <= n) {
                    res[0]++;
                }
                helper(n, d, i+1, p, res);
            }
            d[i] = 0;
        }

        int number(int[] d, int ind) {
            int res = 0;
            for (int i = 0; i <= ind; i++) {
                res = res*10 + d[i];
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rotatedDigits(10));
        System.out.println(sol.rotatedDigits(857));
    }

}
