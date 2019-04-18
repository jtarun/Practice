package com.jtarun.practice.leetcode;

/** 748
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate.
 * Such a word is said to complete the given string licensePlate
 *
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 *
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 *
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP",
 * the word "pair" does not complete the licensePlate, but the word "supper" does.
 *
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 */
public class ShortestCompletingWord {

    private static class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] h = new int[26];
            int total = 0;
            for (char c  : licensePlate.toCharArray()) {
                if (c  >= 'A' && c <= 'Z') c += 32;
                if (c >= 'a' && c <= 'z') {
                    h[c-'a']++;
                    total++;
                }
            }

            int min = Integer.MAX_VALUE;
            String res = "";
            for (String word : words) {
                int[] cnt = new int[26];
                for (int i = 0; i < cnt.length; i++) cnt[i] = h[i];

                int count = total;
                for (char c : word.toCharArray()) {
                    if (cnt[c-'a'] > 0) {
                        count--;
                        cnt[c-'a']--;
                        if (count == 0) break;
                    }

                }

                if (count == 0 && word.length() < min) {
                    min = word.length();
                    res = word;
                }

            }

            return res;
        }

    }

}
