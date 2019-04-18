package com.jtarun.practice.codility.grab;

/**
 * There are N trees growing along a street. One of the trees needs to be cut down, but all the remaining trees
 * should be in non-decreasing order of height. Your goal is to find the number of ways this can be done.
 */
public class Test2 {

    private static class Solution {
        public int solution(int[] A) {
            int n = A.length;
            if (n <= 2) return n;

            int res = 0;
            for (int i = 0; i < n; i++) {
                if(sorted(A, i)) res++;
            }
            return res;
        }

        boolean sorted(int[] A, int ind) {
            int n = A.length;

            int i = ind < 2 ? 2 : 1;
            while (i < n) {
                if (i != ind) {
                    int prev = (i-1 == ind) ? i-2 : i-1;
                    if (A[i] < A[prev]) return false;
                }
                i++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{3,4,5,4})); // 2
        System.out.println(sol.solution(new int[]{4,5,2,3,4})); // 0
        System.out.println(sol.solution(new int[]{1,2,3,3,5,6,7})); // 7

        System.out.println(sol.solution(new int[]{3,3,3})); // 3
        System.out.println(sol.solution(new int[]{3,1,2})); // 1
        System.out.println(sol.solution(new int[]{3,1,1})); // 1
        System.out.println(sol.solution(new int[]{3,2,1})); // 0
        System.out.println(sol.solution(new int[]{1,2,3,})); // 3
        System.out.println(sol.solution(new int[]{1,2,2,3})); // 4
        System.out.println(sol.solution(new int[]{1,2})); // 2
        System.out.println(sol.solution(new int[]{2,1})); // 2
        System.out.println(sol.solution(new int[]{2})); // 1

    }



}
