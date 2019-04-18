package com.jtarun.practice.interviewbit.string;

class Solution2 {
  public String intToRoman(int a) {

    StringBuilder res = new StringBuilder();
    int n = a/1000;
    while (n-- > 0) {
      res.append("M");
    }
    a = a - (a/1000) * 1000;

    n = a/100;
    if (n > 0) {
      if (n == 9) res.append("CM");
      else if (n == 4) res.append("CD");
      else {
        if (n >= 5) {
          res.append("D");
          n = n - 5;
        }
        while (n-- > 0) {
          res.append("C");
        }
      }
    }

    a = a- (a/100) * 100;

    n = a/10;
    if (n > 0) {
      if (n == 9) res.append("XC");
      else if (n ==4) res.append("XL");
      else {
        if (n >= 5) {
          res.append("L");
          n = n - 5;
        }
        while (n-- > 0) {
          res.append("X");
        }
      }
    }

    a = a- (a/10) * 10;
    if (a == 9) res.append("IX");
    else if (a == 4) res.append("IV");
    else {
      if (a >= 5) {
        res.append("V");
        a = a - 5;
      }
      while (a-- > 0) {
        res.append("I");
      }
    }
    return res.toString();
  }
}



public class IntegerToRoman {
  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    System.out.println(sol.intToRoman(67));
  }

}
