package com.jtarun.practice.interviewbit.string;

class Solution8 {
  public int compareVersion(String a, String b) {

    String[] s1 = a.split("\\.");
    String[] s2 = b.split("\\.");

    int n1 = s1.length;
    int n2 = s2.length;
    for (int i = 0; i < Math.max(n1, n2); i++) {
      String x, y;
      if (i < n1) x = s1[i];
      else x = "0";
      if (i < n2) y = s2[i];
      else y = "0";

      int c = compare(x, y);
      if (c != 0) return c;
    }
    return 0;
  }

  int compare(String s1, String s2) {
    int n1 = s1.length();
    int n2 = s2.length();

    int i =0, j = 0;
    while (i < n1 && s1.charAt(i) == '0') i++;
    while (j < n2 && s2.charAt(j) == '0') j++;
    if (i > 0) {
      s1 = s1.substring(i);
      n1 = s1.length();
    }
    if (j > 0) {
      s2 = s2.substring(j);
      n2 = s2.length();
    }

    int d = Math.max(n1, n2);
    StringBuilder zeros = new StringBuilder();
    for (int k = 0; k < d; k++) zeros.append("0");

    if (n1 < n2) {
      s1 = zeros.toString() + s1;
    } else if (n1 > n2) {
      s2 = zeros.toString() + s2;
    }

    int c = s1.compareTo(s2);
    if (c == 0) return 0;
    return c < 0 ? -1 : 1;
  }

}


public class CompareVersions {
  public static void main(String[] args) {
    Solution8 sol = new Solution8();
    System.out.println(sol.compareVersion("4444371174137455", "5.168"));

  }

}
