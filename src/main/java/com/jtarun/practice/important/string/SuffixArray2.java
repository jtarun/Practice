package com.jtarun.practice.important.string;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray2 {
  class L {
    int[] r = new int[2];
    int p;
  }

  private String s;
  private int n;
  private L[] l;
  private int[][] p;
  private int[] lcp;
  private int steps = 0;

  SuffixArray2(String str) {
    this.s = str;
    n = s.length();
    l = new L[n];
    for (int i = 0; i < n;i++) {
      l[i] = new L();
    }
    p = new int[17][n];
    lcp = new int[n];
    construct();
  }

  public void construct() {
    for (int i = 0; i < n; i++) {
      p[steps][i] = s.charAt(i) - 'a';
    }

    int cnt = 1;
    for (steps = 1; cnt < n; cnt <<= 1, steps++) {

      for (int i = 0; i < n; i++) {
        l[i].r[0] = p[steps-1][i];
        l[i].r[1] = i + cnt < n ? p[steps-1][i+cnt] : -1;
        l[i].p = i;
      }

      Comparator<L> cmp = (l1, l2) -> {
        return l1.r[0] == l2.r[0] ? (l1.r[1] < l2.r[1] ? -1 : 1) : (l1.r[0] < l2.r[0] ? -1 : 1);
      };

      Arrays.sort(l, cmp);

      for (int i = 0; i < n; i++) {
        p[steps][l[i].p] = i > 0 && ((l[i].r[0] == l[i-1].r[0]) && (l[i].r[1] == l[i-1].r[1]))
            ? p[steps][l[i-1].p] : i;
      }
    }

    constructLCP();
  }

  private void constructLCP() {
    lcp[0] = 0;
    for (int i = 1; i < n; i++) {
      lcp[i] = lcp(l[i].p, l[i-1].p);
    }
  }

  private int lcp(int x, int y) {
    if (x == y) return n - x;
    int res = 0;
    for (int stp = steps-1; stp >= 0 && x < n && y < n; stp--) {
      if (p[stp][x] == p[stp][y]) {
        int len = 1 << stp;
        x += len;
        y += len;
        res += len;
      }
    }
    return res;
  }

  private int countDistinctSubstrings() {
    int res = n - l[0].p;
    for (int i = 1; i < n; i++) {
      res += (n - l[i].p) - lcp[i];
    }
    return res;
  }

  public static void main(String[] args) {
    SuffixArray2 sa = new SuffixArray2("aaaa");
    System.out.println("Distinct substrings : " + sa.countDistinctSubstrings());
  }

}
