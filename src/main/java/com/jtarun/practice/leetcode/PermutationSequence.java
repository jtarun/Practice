package com.jtarun.practice.leetcode;

/** 60
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {

    private static class Solution {

        public String getPermutation(int n, int k) {
            int[] fact = new int[n+1];
            fact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = i * fact[i-1];
            }

            int[] res = new int[n];
            int perms = 0;
            boolean[] used = new boolean[n+1];

            for (int ind = 0; ind < n; ind++) {
                for (int i = 1; i <= n; i++) {
                    if (used[i]) continue;

                    if (perms + fact[n-1-ind] < k) {
                        perms += fact[n-1-ind];
                    } else {
                        used[i] = true;
                        res[ind] = i;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : res) sb.append(x);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getPermutation(4, 9));
    }

}
