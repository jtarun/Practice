package com.jtarun.practice.leetcode;

/** 405
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero
 * character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 */
public class ConvertToHex {

    private static class Solution {
        public String toHex(int n) {
            if ( n== 0) {
                return "0";
            }

            StringBuilder res = new StringBuilder();
            while (n != 0) {
                res.append(toHexChar(n & 0xf));
                n = n >>> 4;
            }

            return res.reverse().toString();
        }

        private char toHexChar(int n) {
            if (n <= 9) {
                return (char)(n + '0');
            }

            return (char)((n - 10) + 'a');
        }
    }

}
