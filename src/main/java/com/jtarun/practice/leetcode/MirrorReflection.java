package com.jtarun.practice.leetcode;

/** 858
 * There is a special square room with mirrors on each of the four walls.
 * Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
 *
 * The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at
 * a distance q from the 0th receptor.
 *
 * Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor
 * eventually.)
 */
public class MirrorReflection {

    // https://leetcode.com/problems/mirror-reflection/discuss/141765/Java-short-solution-with-a-sample-drawing
    private static class Solution {
        public int mirrorReflection(int p, int q) {
            while (p%2 == 0 &&  q % 2 == 0) {
                p = p/2;
                q = q/2;
            }

            if (p % 2 == 0) return 2;
            if (q % 2 == 0) return 0;

            return 1;
        }
    }

}
