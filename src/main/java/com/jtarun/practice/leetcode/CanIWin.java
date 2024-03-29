package com.jtarun.practice.leetcode;

/** 464
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10.
 * The player who first causes the running total to reach or exceed 100 wins.
 *
 * What if we change the game so that players cannot re-use integers?
 *
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without
 * replacement until they reach a total >= 100.
 *
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move
 * can force a win, assuming both players play optimally.
 *
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger
 * than 300.
 *
 * Example
 *
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * Output:
 * false
 *
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 */
public class CanIWin {

    private static class Solution {

        public boolean canIWin(int max, int target) {
            int sum = max * (max + 1) / 2;
            if (sum < target) return false;
            int[] dp = new int[1<<max];

            return helper(target, 0, max, dp);
        }

        private boolean helper(int target, int used, int max, int[] dp) {

            if (dp[used] > 0) return dp[used] == 1 ? true : false;

            boolean res = false;
            for (int i = 1; i <= max; i++) {

                if ((used & (1<<(i-1))) == 0) {
                    if (target - i <= 0) return true;

                    if (!helper(target-i, used | (1<<(i-1)), max, dp))  {
                        res = true;
                        break;
                    }

                }

            }

            dp[used] = res ? 1: 2;
            return res;
        }

    }

}
