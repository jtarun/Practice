package com.jtarun.practice.important.string;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {
  class L {
    public int[] nr = new int[2];
    public int p;
  }

  private int[][] sa;
  private String s;
  private int steps = 0;
  private L[] l;
  private int[] lcp;

  SuffixArray(String s) {
    this.s = s;
    construct();
  }

  private void construct() {
    int n = s.length();
    sa = new int[17][n];
    l = new L[n];
    for (int i = 0; i < n; i++) l[i] = new L();

    for (int i = 0; i < n; i++) {
      sa[steps][i] = s.charAt(i) - 'a';
    }
    int cnt = 1;
    for (steps = 1; cnt < n; cnt = cnt << 1, steps++) {

      for (int i = 0; i < n; i++) {
        l[i].nr[0] = sa[steps - 1][i];
        l[i].nr[1] = i + cnt < n ? sa[steps -1][i + cnt] : -1;
        l[i].p = i;
      }

      Comparator<L> comparator = (l1, l2) -> {
        return l1.nr[0] == l2.nr[0] ?  (l1.nr[1] < l2.nr[1] ? -1 : 1) : (l1.nr[0] < l2.nr[0] ? -1 : 1);
      };

      Arrays.sort(l, comparator);

      for (int i = 0; i < n; i++) {
        sa[steps][l[i].p] = i > 0 && ((l[i].nr[0] == l[i-1].nr[0]) && (l[i].nr[1] == l[i-1].nr[1]))
            ? sa[steps][l[i-1].p] : i;
      }

    }

    steps--;
    constructLCP();
  }

  private void constructLCP() {
    int n = s.length();
    lcp = new int[n];
    lcp[0] = 0;
    for (int i = 1; i < n; i++) {
      lcp[i] = lcp(l[i-1].p, l[i].p);
    }
  }

  private int lcp(int x, int y) {
    int n = s.length();
    if (x == y) return n - x ;
    int res = 0;
    for (int stp = steps; stp >= 0; stp--) {

      if (sa[stp][x] == sa[stp][y]) {
        int len = 1 << stp;
        res += len;
        x += len;
        y += len;
      }

      if (x >= n ||  y >= n) {
        break;
      }

    }
    return res;
  }

  public void printSuffixArray() {
    int n = s.length();
    for (int i = 0; i < n; i++) {
      System.out.print(l[i].p + ", ");
    }
    System.out.println();
  }

  public void debugRank() {
    for (int i = 0; i <= steps; i++) {
      for (int j = 0; j <s.length(); j++) {
        System.out.print(sa[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void printRanks() {
    int n = s.length();
    for (int i = 0; i < n; i++) {
      System.out.print(sa[steps][i] + ", ");
    }
    System.out.println();
  }

  private void printLCP() {
    for (int i = 0; i < s.length(); i++) {
      System.out.print(lcp[i] + ", ");
    }
    System.out.println();
  }

  public int distinctSubstringCount() {
    int n = s.length();
    int res = n - l[0].p;

    for (int i = 1; i < n; i++) {
      res += (n - l[i].p) - lcp[i];
    }

    return res;
  }

  public static void main(String[] args) {
    SuffixArray sa = new SuffixArray("aaaaa");
    sa.debugRank();
    System.out.println("-------------------------");
    sa.printRanks();
    sa.printSuffixArray();
    sa.printLCP();
    System.out.println("total distinct substrings : " + sa.distinctSubstringCount());
  }

}
