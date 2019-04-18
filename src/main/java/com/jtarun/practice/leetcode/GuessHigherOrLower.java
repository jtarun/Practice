package com.jtarun.practice.leetcode;

/** 374
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 */
public class GuessHigherOrLower {
    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

    private class GuessGame {
        int guess(int n) {
            return 0; // dummy value;
        }
    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int lo = 1, hi = n;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                int g = guess(mid);
                if (g == 1) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            return lo;
        }
    }

}
