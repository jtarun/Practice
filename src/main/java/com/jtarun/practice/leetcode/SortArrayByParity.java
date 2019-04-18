package com.jtarun.practice.leetcode;

/** 905
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by
 * all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 */
public class SortArrayByParity {

    private static class Solution {
        public int[] sortArrayByParity(int[] A) {
            int i = 0, j = A.length - 1;

            while (i < j) {

                if (A[i] % 2 == 0) {
                    i++;
                } else {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    j--;
                }

            }

            return A;
        }


    }
}
