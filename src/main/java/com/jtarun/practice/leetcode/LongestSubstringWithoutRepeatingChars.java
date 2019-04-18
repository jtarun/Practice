package com.jtarun.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChars {
  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      Map<Character, Integer> h = new HashMap<>();
      int start = 0, max_len = 0;
      for (int i = 0; i < s.length(); i++) {
        Character c = s.charAt(i);
        if (h.containsKey(c)) {
          int new_start = h.get(c) + 1;
          for (int j = start; j < new_start; j++) {
            h.remove(s.charAt(j));
          }
          start = new_start;
        }
        if (i - start + 1 > max_len) {
          max_len = i - start + 1;
        }

        h.put(c, i);
      }
      return max_len;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    String s = "abcabcbb";
    System.out.println(sol.lengthOfLongestSubstring(s));

    s = "bbbbb";
    System.out.println(sol.lengthOfLongestSubstring(s));

    s = "pwwkew";
    System.out.println(sol.lengthOfLongestSubstring(s));

    s = "abba";
    System.out.println(sol.lengthOfLongestSubstring(s));
  }

}
