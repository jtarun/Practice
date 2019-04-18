package com.jtarun.practice.leetcode;

/** 214 (Hard)
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 */
public class ShortestPalindrome {

    private static class Solution {

        public String shortestPalindrome(String s) {
            int n = s.length();
            if (n <= 1) return s;

            int i = 0, j = 1;
            int[] lcs = new int[n];
            while (j < n) {
                char c = s.charAt(i);
                char d = s.charAt(j);

                if (c == d) {
                    lcs[j] = i+1;
                    i++;
                    j++;
                } else {
                    if (i == 0) j++;
                    else {
                        i = lcs[i-1];
                    }
                }

            }

            j = n-1;
            i = 0;
            while (i < j) {
                char c = s.charAt(i);
                char d = s.charAt(j);

                if (c == d) {
                    i++;
                    j--;
                } else {
                    if (i == 0) j--;
                    else i = lcs[i-1];
                }
            }

            int len = 1;
            if (i == j) {
                if (i != 0) len = i*2+1;
            } else {
                len = i*2;
            }

            if (len == n) return s;

            return new StringBuilder(s.substring(len, n)).reverse().append(s).toString();
        }


        // O(n^2) algo (MLE)
        public String shortestPalindrome2(String s) {
            boolean[][] p = new boolean[s.length()][s.length()];

            for (int l = 1; l <= s.length(); l++) {
                for (int i = 0; i+l-1 < s.length(); i++) {
                    int j = i + l - 1;

                    if (l == 1) {
                        p[i][j] = true;
                    } else if (l == 2) {
                        p[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        p[i][j] = (s.charAt(i) == s.charAt(j)) && p[i+1][j-1];
                    }

                }
            }

            int j = s.length()-1;
            for (; j >= 0; j--) {
                if (p[0][j]) {
                    break;
                }
            }

            if (j == s.length()-1) return s;

            String sub = s.substring(j+1, s.length());
            String res = new StringBuilder(sub).reverse().append(s).toString();

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.shortestPalindrome("abbacd"));
    }

}
