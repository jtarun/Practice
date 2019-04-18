package com.jtarun.practice.leetcode;

import java.util.*;

/** 830
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of
 * every large group.
 *
 * The final answer should be in lexicographic order.
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 */
public class PositionsOfLargeGroups {

    private static class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            List<List<Integer>> res = new ArrayList<>();

            int i = 0;
            while (i < S.length()) {
                int j = i+1;
                while (j < S.length() && S.charAt(j) == S.charAt(i)) j++;

                if (j-i >= 3) {
                    res.add(Arrays.asList(i, j-1));
                }

                i = j;
            }

            return res;
        }
    }

}
