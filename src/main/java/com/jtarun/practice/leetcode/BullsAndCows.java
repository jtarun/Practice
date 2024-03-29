package com.jtarun.practice.leetcode;

import java.util.*;

/** 299
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend
 * to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits
 * in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match
 * the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and
 * hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls
 * and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 */
public class BullsAndCows {

    private static class Solution {
        public String getHint(String secret, String guess) {
            int[] h = new int[10];
            for (int i = 0; i < secret.length(); i++) {
                h[secret.charAt(i)-'0']++;
            }

            Set<Integer> bulls = new HashSet<>();
            for (int i = 0; i < Math.min(guess.length(), secret.length()); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    bulls.add(i);
                    h[guess.charAt(i)-'0']--;
                }
            }

            int cows = 0;
            for (int i = 0; i < guess.length(); i++) {
                if (!bulls.contains(i)) {
                    char c = guess.charAt(i);
                    if (h[c-'0'] > 0) {
                        h[c-'0']--;
                        cows++;
                    }
                }
            }

            return bulls.size()+"A"+cows+"B";
        }
    }

}
