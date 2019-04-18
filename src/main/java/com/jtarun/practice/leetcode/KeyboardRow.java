package com.jtarun.practice.leetcode;

import java.util.*;

/** 500
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's
 * of American keyboard like the image below.
 *
 */
public class KeyboardRow {

    private static class Solution {
        public String[] findWords(String[] words) {
            List<String> res = new ArrayList<>();
            String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            int[] h = new int[256];

            int cnt = 0;
            for (String row : rows) {
                cnt++;
                for (char c : row.toCharArray()){
                    h[c] = cnt;
                    h[c-32] = cnt;
                }
            }

            for (String word : words) {
                if (word.isEmpty()) {
                    res.add("");
                    continue;
                }
                int row = h[word.charAt(0)];
                boolean success = true;
                for (char c : word.toCharArray()) {
                    if (h[c] != row) {
                        success = false;
                        break;
                    }
                }
                if (success) res.add(word);
            }


            String[] ans = new String[res.size()];

            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }

            return ans;
        }
    }

}
