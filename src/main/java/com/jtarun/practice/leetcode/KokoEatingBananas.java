package com.jtarun.practice.leetcode;

/** 875
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.
 * The guards have gone and will come back in H hours.
 *
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas,
 * and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead,
 * and won't eat any more bananas during this hour.
 *
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 *
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 */
public class KokoEatingBananas {

    private static class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int lo = 1, hi = 1;
            for (int pile : piles) hi = Math.max(hi, pile);

            while (lo < hi) {

                int mid = lo + (hi - lo) /2;

                int hours = 0;
                for (int pile : piles) {
                    hours += pile/mid;
                    if (pile % mid != 0) hours++;
                }

                if (hours > H) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }

            }

            return lo;
        }
    }

}
