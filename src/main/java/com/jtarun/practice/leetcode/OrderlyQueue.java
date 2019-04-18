package com.jtarun.practice.leetcode;

import java.util.*;

/** 899 (Hard)
 * A string S of lowercase letters is given.  Then, we may make any number of moves.
 * In each move, we choose one of the first K letters (starting from the left), remove it, and place it at the
 * end of the string.
 *
 * Return the lexicographically smallest string we could have after any number of moves.
 *
 * Example 1:
 *
 * Input: S = "cba", K = 1
 * Output: "acb"

 * Input: S = "baaca", K = 3
 * Output: "aaabc"
 * Note:
 *
 * 1 <= K <= S.length <= 1000
 * S consists of lowercase letters only.
 *
 */
public class OrderlyQueue {

    private static class Solution {
        public String orderlyQueue(String S, int K) {
            if (K >= 2)  {
                char[] str = S.toCharArray();
                Arrays.sort(str);
                return new String(str);
            }

            // k = 1
            String s = S + S;
            String res = S;
            for (int i = 1; i < S.length(); i++) {
                String sub = s.substring(i, i+S.length());
                if (sub.compareTo(res) < 0) res = sub;
            }

            return res;
        }
    }

}
