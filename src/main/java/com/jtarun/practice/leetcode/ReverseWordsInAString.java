package com.jtarun.practice.leetcode;

public class ReverseWordsInAString {

    private static class Solution {
        public String reverseWords(String s) {
            if (s.isEmpty()) return "";

            char[] str = s.toCharArray();

            int start = 0, end = s.length()-1;
            while (start <= end && space(str[start])) start++;
            while (end >= start && space(str[end])) end--;

            StringBuilder sb = new StringBuilder();
            while (start <= end) {

                int j = start;
                while (j <= end && !space(str[j])) j++;

                String reverseWord = reverse(str, start, j-1);
                if (sb.length() != 0) sb.append(" ");
                sb.append(reverseWord);

                start = j;
                while (start <= end && space(str[start])) start++;
            }

            return sb.reverse().toString();
        }

        private boolean space(char c) {
            return c == ' ' || c == '\t';
        }

        private String reverse(char[] s, int i, int j) {
            StringBuilder res = new StringBuilder();
            for (int k = j; k >= i; k--) {
                res.append(s[k]);
            }
            return res.toString();
        }

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("    "));
    }

}
