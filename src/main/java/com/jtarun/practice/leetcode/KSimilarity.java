package com.jtarun.practice.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** 854
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A
 * exactly K times so that the resulting string equals B.
 *
 * Given two anagrams A and B, return the smallest K for which A and B are K-similar.
 */
public class KSimilarity {

    private static class Solution {
        public int kSimilarity(String A, String B) {
            if (A.equals(B)) return 0;

            Queue<String> q = new LinkedList<>();
            q.add(A);
            Set<String> visited = new HashSet<>();
            visited.add(A);
            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                level++;
                while (size-- > 0) {
                    String t = q.poll();

                    int i = 0;
                    while (B.charAt(i) == t.charAt(i)) i++;

                    for (int j = i+ 1; j < t.length(); j++) {
                        if (B.charAt(j) == t.charAt(j) || t.charAt(j) != B.charAt(i)) continue;
                        String newStr = t.substring(0,i) + t.charAt(j) + t.substring(i+1, j) + t.charAt(i) + t.substring(j+1);
                        if (newStr.equals(B)) return level;
                        if (visited.add(newStr)) {
                            q.offer(newStr);
                        }
                    }
                }
            }

            return Integer.MAX_VALUE;
        }


        // This solution leads to TLE as it is (n)^n solution.
        public int kSimilarity2(String A, String B) {
            if (A.equals(B)) return 0;

            Queue<String> q = new LinkedList<>();
            q.add(A);
            Set<String> visited = new HashSet<>();
            visited.add(A);
            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                level++;
                while (size-- > 0) {
                    String t = q.poll();

                    for (int i = 1; i < t.length(); i++) {
                        char c = t.charAt(i);
                        if (c == B.charAt(i)) continue;
                        for (int j = 0; j < i; j++) {
                            char d = t.charAt(j);
                            String newStr = t.substring(0, j) + c + t.substring(j+1, i) + d + t.substring(i+1);
                            if (visited.add(newStr)) {
                                if (newStr.equals(B)) return level;
                                q.offer(newStr);
                            }
                        }

                    }
                }
            }

            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.kSimilarity("abccaacceecdeea", "bcaacceeccdeaae" );
        System.out.println(res);
    }

}
