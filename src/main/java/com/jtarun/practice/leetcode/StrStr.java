package com.jtarun.practice.leetcode;


/**
 * 28
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part
 * of haystack.
 */
public class StrStr {
    private static class Solution {
        public int strStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();

            if (n == 0) return 0;

            int[] lcp = new int[n];

            constructLCP(needle, lcp);

            int i = 0, j = 0;
            while (i < m) {

                char c = haystack.charAt(i);
                char d = needle.charAt(j);

                if (c == d) {
                    if (j == n - 1) {
                        return i - n + 1;
                    } else {
                        i++;
                        j++;
                    }
                } else {
                    if (j == 0) i++;
                    else {
                        j = lcp[j - 1];
                    }
                }
            }

            return -1;
        }

        private void constructLCP(String s, int[] lcp) {
            int n = s.length();
            int i = 1, j = 0;
            while (i < n) {
                char c = s.charAt(j);
                char d = s.charAt(i);

                if (c == d) {
                    lcp[i++] = ++j;
                } else {
                    if (j == 0) {
                        i++;
                    } else {
                        j = lcp[j - 1];
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strStr("hello", "ll"));
        System.out.println(sol.strStr("aaaaa", "bba"));
    }


}
