package com.jtarun.practice.codility.article;

public class CoinFlip {

    static class Solution {
        int solution(int[] A) {
            int n = A.length;
            int result = 0;
            for (int i = 0; i < n - 1; i++) {
                if (A[i] == A[i + 1])
                    result = result + 1;
            }
            int r = n > 1 ? -2 : 0;
            for (int i = 0; i < n && n > 1; i++) {
                int count = 0;
                if (i > 0) {
                    if (A[i - 1] != A[i])
                        count = count + 1;
                    else
                        count = count - 1;
                }
                if (i < n - 1) {
                    if (A[i + 1] != A[i])
                        count = count + 1;
                    else
                        count = count - 1;
                }
                r = Math.max(r, count);
            }
            return result + r;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0,1}));
    }

}
