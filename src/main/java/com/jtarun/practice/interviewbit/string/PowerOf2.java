package com.jtarun.practice.interviewbit.string;

class Solution4 {
  public int power(String a) {

    String b = toBinary(a);

    int i = b.indexOf('1');
    if (i == -1) return 0;
    i++;
    while (i < b.length()) {
      if (b.charAt(i) == '1') return 0;
      i++;
    }
    return 1;
  }

  String toBinary(String a) {
    StringBuilder res = new StringBuilder();
    while (!allzero(a)) {
      int last = (int) (a.charAt(a.length()-1));
      if ((last & 1) == 1) res.append("1");
      else res.append("0");
      a = divideBy2(a);
    }

    return res.reverse().toString();
  }

  String divideBy2(String a) {
    StringBuilder res = new StringBuilder();
    int carry = 0;
    int i = 0;
    int n = a.length();
    while (i < n) {
      int d = (int) (a.charAt(i) - '0');
      int x = (carry*10 + d);
      if (x == 0 && res.length() == 0) {
      } else res.append(x/2);
      carry = x - (x/2)*2;
      i++;
    }
    return res.toString();
  }



  boolean allzero(String a) {
    for (int i = 0; i < a.length(); i++) {

      if (a.charAt(i) != '0') return false;

    }

    return true;
  }


}



public class PowerOf2 {

  public static void main(String[] args) {
    Solution4 sol = new Solution4();

    for (int i  = 0; i < 20; i++) {
      int b = sol.power(Integer.toString(i));
      System.out.println(b);
    }
  }

}
