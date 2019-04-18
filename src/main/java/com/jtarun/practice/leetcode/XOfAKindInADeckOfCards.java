package com.jtarun.practice.leetcode;

import java.util.*;

/** 914
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1
 * or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 *
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 */
public class XOfAKindInADeckOfCards {

    private static class Solution {

        public boolean hasGroupsSizeX(int[] deck) {
            if (deck.length < 2) return false;

            Map<Integer, Integer> h = new HashMap<>();
            for (int d : deck) h.put(d, h.getOrDefault(d, 0)+1);

            int gcd;
            List<Integer> values = new ArrayList<>(h.values());
            int factor = values.get(0);
            for (int i = 1; i < values.size(); i++) {
                factor = gcd(factor, values.get(i));
                if (factor == 1) return false;
            }

            return true;
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a%b);
        }

        public boolean hasGroupsSizeX2(int[] deck) {
            if (deck.length < 2) return false;

            Map<Integer, Integer> h = new HashMap<>();
            for (int d : deck) h.put(d, h.getOrDefault(d, 0)+1);

            int min = deck.length+1;
            for (int x : h.values()) min = Math.min(min, x);
            if (min < 2) return false;
            if (h.size() == 1) return true;

            for (int i = 2; i <= min; i++) {
                boolean res = true;
                for (int x : h.values()) {
                    if (x % i != 0) {
                        res = false;
                        break;
                    }
                }
                if (res) return true;
            }

            return false;
        }
    }

}
