package com.jtarun.practice.leetcode;

import java.util.*;

/** 131
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {

    private static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            int n = s.length();
            boolean[][] p = new boolean[n][n];

            for (int l = 1; l <= n; l++) {
                for (int i = 0; i + l - 1 < n; i++) {

                    int j = i + l - 1;
                    if (l <= 2) {
                        p[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        p[i][j] = p[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                    }
                }
            }

            helper(s, 0, res, new ArrayList<String>(), p);

            return res;
        }

        private void helper(String s, int ind, List<List<String>> res, List<String> temp, boolean[][] p) {
            int n = s.length();
            if (ind == n) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = ind; i < n; i++) {

                if (p[ind][i]) {
                    temp.add(s.substring(ind, i+1));
                    helper(s, i+1, res, temp, p);
                    temp.remove(temp.size()-1);
                }

            }

        }

    }

}
