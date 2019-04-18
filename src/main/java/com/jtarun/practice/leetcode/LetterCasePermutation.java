package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 */
public class LetterCasePermutation {
    private static class Solution {
        public List<String> letterCasePermutation(String s) {
            List<String> res = new ArrayList<>();

            int n = s.length();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (isDigit(s.charAt(i))) cnt++;
            }
            cnt = n - cnt;

            int end = 1 << cnt;
            for (int i = 0; i < end; i++) {
                StringBuilder l = new StringBuilder();
                int k = 0;
                for (int j = 0; j < n; j++) {
                    if (isDigit(s.charAt(j))) {
                        l.append(s.charAt(j));
                    } else {
                        if ((i & (1 << k)) == 0) {
                            l.append(toUpper(s.charAt(j)));
                        } else {
                            l.append(toLower(s.charAt(j)));
                        }
                        k++;
                    }
                }
                res.add(l.toString());
            }

            return res;
        }

        private char toUpper(char c) {
            if ( c >= 'A' && c <= 'Z') {
                return c;
            }
            return (char) (c - 32);
        }

        private char toLower(char c) {
            if (c >= 'a' && c <= 'z') {
                return c;
            }
            return (char) (c + 32);
        }

        private boolean isDigit(char c) {
            return (c >= '0') && (c <= '9');
        }
    }
}
