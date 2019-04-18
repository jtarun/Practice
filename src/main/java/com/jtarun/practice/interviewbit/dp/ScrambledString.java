package com.jtarun.practice.interviewbit.dp;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
  int[][][] dp;

  public int isScramble(final String a, final String b) {
    int n = a.length();
    dp = new int[n][n][n+1];

    for (int[][] twod : dp) {
      for (int[] oned : twod) {
        Arrays.fill(oned, -1);
      }
    }

    return isScramble(a, 0, b, 0, b.length()) ? 1:0;

  }

  boolean isScramble(final String a, int i, final String b, int j, int l) {
    if (dp[i][j][l] != -1) return dp[i][j][l] == 1;

    System.out.println(i + " " + j + " " + l);

    if (!isAnagram(a, b, i, j, l)) {
      dp[i][j][l] = 0;
      return false;
    }

    if (l == 1) {
      dp[i][j][l] = 1;
      return true;
    }

    if (equal(a,b,i,j,l)) {
      dp[i][j][l] = 1;
      return true;
    }

    boolean res = false;
    for (int k =1; k < l; k++) {
      res = isScramble(a,i,b,j,k) && isScramble(a, i+k, b, j+k, l-k);
      if (res) break;
      res = isScramble(a,i,b,j+l-k,k) && isScramble(a, i+k, b, j, l-k );
      if (res) break;
    }

    dp[i][j][l] = res ? 1: 0;
    return res;
  }

  boolean equal(String a, String b, int i, int j, int l) {
    for (int k = 0; k < l; k++) {
      char c = a.charAt(i+k);
      char d = b.charAt(j+k);
      if (c != d) return  false;
    }
    return true;
  }

  boolean isAnagram(String a, String b, int i, int j, int l) {

    HashMap<Character, Integer> h = new HashMap<>();
    for (int p = 0; p<l; p++) {
      char c = a.charAt(i+p);
      int cnt = h.computeIfAbsent(c, k -> new Integer(0));
      h.put(c, cnt+1);
    }

    int count=0;
    for (int p = 0; p <l; p++) {
      char c = b.charAt(j+p);
      if (h.containsKey(c)) {
        int v = h.get(c);
        if (v > 0) {
          count++;
          h.put(c, v-1);
        }else return false;
      } else return false;
    }

    return count == l;
  }

}




public class ScrambledString {
  public static void main(String[] args) {
    Solution sol = new Solution();
    //System.out.println(sol.isScramble("abbbcbaaccacaacc", "acaaaccabcabcbcb"));
    System.out.println(sol.isScramble("ABCDE", "CAEBD"));
    //System.out.println(sol.isScramble("great", "rgate"));
  }

}
