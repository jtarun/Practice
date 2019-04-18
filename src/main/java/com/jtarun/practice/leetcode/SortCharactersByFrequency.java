package com.jtarun.practice.leetcode;

import java.util.*;

/** 451
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class SortCharactersByFrequency {

    private static class Solution {
        public String frequencySort(String s) {
            int[] h = new int[256];
            for (int i = 0; i < s.length(); i++) h[s.charAt(i)]++;

            List<int[]> l = new ArrayList<>();
            for (int i = 0; i < 256; i++) {
                if (h[i] > 0) l.add(new int[]{i, h[i]});
            }

            Collections.sort(l, (a,b)-> Integer.compare(b[1],a[1]));

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < l.size(); i++) {
                int[] t = l.get(i);
                char c = (char)(t[0]);
                int cnt = t[1];

                while (cnt-- > 0)sb.append(c);
            }

            return sb.toString();
        }
    }

}
