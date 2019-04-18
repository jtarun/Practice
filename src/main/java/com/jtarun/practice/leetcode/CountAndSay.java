package com.jtarun.practice.leetcode;

/*
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountAndSay {
  private static class Solution {

    public String countAndSay(int n) {
      if (n == 1) {
        return "1";
      }

      String ans = "1";
      for (int i = 2; i <= n; i++) {
        ans = countAndSay(ans);
      }

      return ans;
    }

    private String countAndSay(String s) {
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < s.length(); ) {
        int j = i;
        while (j < s.length() && s.charAt(j) == s.charAt(i)) {
          j++;
        }
        int cnt = j - i;
        res.append(cnt).append(s.charAt(i));

        i = j;
      }
      return res.toString();
    }

  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.countAndSay(1));
    System.out.println(" ----------- ");
    System.out.println(sol.countAndSay(4));
  }

}
