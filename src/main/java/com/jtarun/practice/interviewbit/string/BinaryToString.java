package com.jtarun.practice.interviewbit.string;

class Solution3 {
  public String addBinary(String a, String b) {
    int n1 = a.length();
    int n2 = b.length();
    if (n1 == 0)return b;
    if (n2 == 0) return a;

    int i = n1 - 1, j = n2 - 1;

    StringBuilder res = new StringBuilder();
    int carry = 0;
    while ( i >= 0 && j >= 0) {
      int sum = (int)(a.charAt(i) - '0') + (int)(b.charAt(j) - '0') + carry;
      if (sum == 3) {
        carry = 1;
        res.append("1");
      } else if (sum == 2) {
        carry = 1;
        res.append("0");
      } else {
        carry = 0;
        res.append(Integer.toString(sum));
      }
      i--;
      j--;
    }

    while (i >= 0) {
      int sum = (int)(a.charAt(i) - '0') + carry;
      if (sum == 3) {
        carry = 1;
        res.append("1");
      } else if (sum == 2) {
        carry = 1;
        res.append("0");
      } else {
        carry = 0;
        res.append(Integer.toString(sum));
      }
      i--;
    }

    while (j >= 0) {
      int sum = (int)(b.charAt(j) - '0') + carry;
      if (sum == 3) {
        carry = 1;
        res.append("1");
      } else if (sum == 2) {
        carry = 1;
        res.append("0");
      } else {
        carry = 0;
        res.append(Integer.toString(sum));
      }
      j--;
    }

    if (carry > 0) {
      res.append(carry);
    }

    return res.reverse().toString();
  }
}



public class BinaryToString {

  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    //String res = sol.addBinary("11", "110");
    String res = sol.addBinary("110", "11");
    System.out.println(res);
  }

}
