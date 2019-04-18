package com.jtarun.practice.codility.grab;

import java.util.*;

/**
 * Write a function which given two integers A and B returns a String that has exactly A 'a' and B 'b'
 * with no 3 consecutive letters being same. ie. aaa and bbb are not allowed.
 */
public class Test1 {

    private static class Solution {
        public String solution(int A, int B) {
            char x = A >= B ? 'a' : 'b';
            char y = A >= B ? 'b' : 'a';

            int min = Math.min(A, B);
            int max = Math.max(A, B);
            int n = max > 2 * min ? 2*min+1 : 2*min;
            int[] cnt = new int[n];
            Arrays.fill(cnt, 1);

            int diff = A + B - n;
            int i = 0;
            while (diff-- > 0) {
                cnt[i]++;
                i+=2;
            }

            StringBuilder res = new StringBuilder();
            i= 0;
            while (i < n) {
                int count = cnt[i];
                while (count-- > 0) res.append(i % 2 == 0 ? x : y);
                i++;
            }

            return res.toString();
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3,5)); // bbabbaba
        System.out.println(sol.solution(5,3)); // aabaabab
        System.out.println(sol.solution(3,3)); // ababab
        System.out.println(sol.solution(1,4)); // bbabb
        System.out.println(sol.solution(4,1)); // aabaa
        System.out.println(sol.solution(1,0)); // a
        System.out.println(sol.solution(0,1)); // b
        System.out.println(sol.solution(0,2)); // bb
        System.out.println(sol.solution(2,0)); // aa
    }

}
