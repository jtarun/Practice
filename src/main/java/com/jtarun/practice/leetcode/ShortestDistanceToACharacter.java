package com.jtarun.practice.leetcode;

/** 821
 * Given a string S and a character C, return an array of integers representing the shortest distance
 * from the character C in the string.
 *
 * Example 1:
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 *
 * Note:
 *
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
public class ShortestDistanceToACharacter {

    private static class Solution {
        public int[] shortestToChar(String S, char C) {
            int n = S.length();
            int[] dist = new int[n];
            int left = n+1;
            for (int i = 0; i < n; i++) {
                char c = S.charAt(i);
                if (c == C) {
                    left = i;
                }
                dist[i] = left <= i ? i-left : left;

            }

            int right = n+1;
            for (int i = n-1; i >= 0; i--) {
                char c = S.charAt(i);
                if (c == C){
                    right = i;
                }
                dist[i] = Math.min(dist[i], right < n ? right-i : right);
            }

            return dist;
        }
    }

}
