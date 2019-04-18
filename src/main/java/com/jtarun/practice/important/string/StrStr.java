package com.jtarun.practice.important.string;


class Solution {
  public int strStr(final String haystack, final String needle) {
    if (needle.isEmpty() || haystack.isEmpty()) return -1;

    int[] lcp = constructLCP(needle);
    return find(haystack, needle, lcp);
  }


  int[] constructLCP(String a) {
    int n = a.length();
    int[] lcp = new int[n];
    int len = 0;
    lcp[0] = 0;
    int i  = 1;
    while (i < n) {
      if (a.charAt(i) == a.charAt(len)) {
        len++;
        lcp[i] =len;
        i++;
      } else {
        if (len > 0) {
          len = lcp[len-1];
        } else {
          lcp[i] = 0;
          i++;
        }
      }
    }
    return lcp;
  }

  int find(String a, String b, int[] lcp) {
    int n  = b.length();
    int j  = 0;
    for (int i = 0; i < a.length();) {

      if (a.charAt(i) == b.charAt(j)) {
        if (j == n-1) {
          return i - n + 1;
        } else {
          j++;
          i++;
        }
      } else {
        if (j != 0) {
          j = lcp[j-1];
        } else i++;
      }

    }

    return -1;
  }

}


public class StrStr {

  public static void main(String[] args) {
    String a = "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
    String b = "babaaa";

    Solution sol = new Solution();
    int i = sol.strStr(a, b);
    System.out.println(i);
  }

}
