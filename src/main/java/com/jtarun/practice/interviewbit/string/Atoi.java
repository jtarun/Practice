package com.jtarun.practice.interviewbit.string;

class Solution {
  public int atoi(final String a) {

    int i  = 0;
    int res = 0;
    int n = a.length();
    int sign = 1;
    while ( i < n && isSpace(a.charAt(i))) i++;

    char c = a.charAt(i);
    if (c=='-' ||  c=='+') {
      if (c == '-') sign = -1;
      i++;
    }

    while (i < n) {
      c = a.charAt(i);

      if (!isNumber(c)) break;

      int prev = res;
      res = res*10 + (int)(c-'0');
      if ((int)(res/100) != (int)(prev/10)) {
        res = (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        break;
      }

      i++;
    }

    if (res*sign*sign != res) {
      res = (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }

    return res*sign;
  }


  boolean isSpace(char c) {
    if (c == ' ' || c == '\t' || c=='\n') return true;
    return false;
  }

  boolean isNumber(char c) {
    int n = (int)(c - '0');
    if (n >=0 && n <=9) return true;
    return false;
  }
}



public class Atoi {
  public static void main(String[] args) {
    Solution sol = new Solution();
    int val = sol.atoi("5121478 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393");
    System.out.println(val);
  }

}
