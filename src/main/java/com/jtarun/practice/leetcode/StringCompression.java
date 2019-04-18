package com.jtarun.practice.leetcode;

/** 443
 * Given an array of characters, compress it in-place.
 *
 * The length after compression must always be smaller than or equal to the original array.
 *
 * Every element of the array should be a character (not int) of length 1.
 *
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input:
 * ["a","a","b","b","c","c","c"]
 *
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 *
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 */
public class StringCompression {

    private static class Solution {
        public int compress(char[] chars) {
            int n = chars.length;
            int i = 0, k = 0;
            while (i < n) {
                int j = i;
                while (j < n && chars[j] == chars[i]) j++;
                int cnt = j-i;
                chars[k++] = chars[i];
                if (cnt > 1) {
                    StringBuilder sb = new StringBuilder();
                    while (cnt > 0) {
                        sb.append(cnt%10);
                        cnt = cnt/10;
                    }
                    String s = sb.reverse().toString();
                    for (int l = 0; l < s.length(); l++) chars[k++] = s.charAt(l);
                }
                i = j;
            }

            return k;
        }
    }

}
