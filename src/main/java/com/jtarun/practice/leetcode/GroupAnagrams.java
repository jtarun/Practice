package com.jtarun.practice.leetcode;

import java.util.*;

/** 49
 * Given an array of strings, group anagrams together.
 */
public class GroupAnagrams {

    private static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            Map<String, List<String>> h = new HashMap<>();
            for (String str : strs) {
                char[] w = str.toCharArray();
                Arrays.sort(w);
                h.computeIfAbsent(new String(w), k -> new ArrayList<>()).add(str);
            }

            for (List<String> g : h.values()) res.add(g);

            return res;
        }
    }

}
