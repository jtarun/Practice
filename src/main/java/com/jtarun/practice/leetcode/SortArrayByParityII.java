package com.jtarun.practice.leetcode;

/** 922
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 */
public class SortArrayByParityII {

    private static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            if (A.length <= 1) return A;

            int i = 0, j = A.length-1;
            while (i < j) {
                while (i < j && A[i] % 2 == 0) i++;
                while (i < j && A[j] % 2 != 0) j--;

                if (i < j) {
                    int t = A[i];
                    A[i] = A[j];
                    A[j] = t;
                    i++;
                    j--;
                }

            }

            i = 1;
            j = A.length-2;

            while (i < j) {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                i += 2;
                j -= 2;
            }

            return A;
        }
    }

}
