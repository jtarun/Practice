package com.jtarun.practice.leetcode;

import java.util.*;

/** 412
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {

    private static class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();

            int[] a = new int[n+1];
            for (int i = 3; i <= n; i+= 3) {
                a[i] = 1;
            }

            for (int i = 5; i <= n; i+= 5) {
                a[i] = (a[i] == 0) ? 2 : 3;
            }

            for (int i = 1; i <= n; i++) {
                if (a[i] == 0) res.add(""+i);
                else if (a[i] == 1) res.add("Fizz");
                else if (a[i] == 2) res.add("Buzz");
                else res.add("FizzBuzz");
            }

            return res;
        }
    }

}
