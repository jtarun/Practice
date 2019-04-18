package com.jtarun.practice.interviewbit.string;


class Solution9 {
  public int isNumber(final String a) {
    String[] s = a.split("e");
    if (s.length > 2) {
      return 0;
    }

    if (s.length == 2) {
      if (isSpace(s[0].charAt(s[0].length() - 1)) ||
          isSpace(s[1].charAt(0))) {
        return 0;
      }
      return (valid(s[0], true) && valid(s[1], false)) ? 1 : 0;
    }

    return valid(s[0], true) ? 1: 0;
  }

  boolean valid(String a, boolean decimal) {
    int n = a.length();
    int i = 0, j = n - 1;
    while (i < j && isSpace(a.charAt(i))) {
      i++;
    }
    while (i < j && isSpace(a.charAt(j))) {
      j--;
    }
    if (i > j) {
      return false;
    }
    try {
      String str = a.substring(i, j + 1);
      if (decimal) {
        if (str.charAt(str.length() - 1) == '.') return false;
        double val = Double.parseDouble(str);
      } else {
        int val = Integer.parseInt(str);
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  boolean isSpace(char c) {
    return (c == ' ' || c == '\t');
  }
}


public class ValidNumber {

  public static void main(String[] args) {
    Solution9 sol = new Solution9();
    //System.out.println(sol.isNumber("1.3"));
    //System.out.println(sol.isNumber("1.00"));
    //System.out.println(sol.isNumber("01.3"));
    //System.out.println(sol.isNumber("1e3"));
    //System.out.println(sol.isNumber("1.4e3"));
    //System.out.println(sol.isNumber("1.4 e3"));
    //System.out.println(sol.isNumber("1.4e 3"));
    //System.out.println(sol.isNumber("1.4 3"));
    System.out.println(sol.isNumber(" 0.0 "));
    System.out.println(sol.isNumber("1."));
  }

}
