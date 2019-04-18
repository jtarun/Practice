package com.jtarun.practice.leetcode;

/** 537
 * Given two strings representing two complex numbers.
 *
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 *
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 */
public class ComplexNumberMultiplication {

    private static class Solution {
        public String complexNumberMultiply(String a, String b) {
            String[] p1 = a.split("\\+");
            String[] p2 = b.split("\\+");

            int r1 = Integer.parseInt(p1[0]);
            int c1 = Integer.parseInt(p1[1].substring(0, p1[1].length()-1));

            int r2 = Integer.parseInt(p2[0]);
            int c2 = Integer.parseInt(p2[1].substring(0, p2[1].length()-1));

            String r = "" + (r1*r2 - c1*c2);
            String c = (c1*r2 + c2*r1) + "i";

            return r + "+" + c;
        }
    }

}
