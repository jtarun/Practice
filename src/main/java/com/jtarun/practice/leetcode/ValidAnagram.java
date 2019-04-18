package com.jtarun.practice.leetcode;

/** 242
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    private static class Solution {
        public boolean isAnagram(String s, String t) {
            int n = s.length();
            if (n != t.length()) return false;

            int[] a = new int[26];
            for (int i = 0; i < n; i++) {
                a[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < n; i++) {
                a[t.charAt(i) - 'a']--;
                if (a[t.charAt(i) - 'a'] < 0) return false;
            }

            return true;
        }
    }

}
