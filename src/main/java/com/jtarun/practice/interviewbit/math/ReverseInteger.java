package com.jtarun.practice.interviewbit.math;

class Solution4 {
  public int reverse(int a) {

    long res = 0;
    int sign = (a>> 31) == -1 ? -1 : 1;
    a = Math.abs(a);
    while ( a > 0) {
      int rem = a % 10;
      res = res*10 + rem;
      a = a/ 10;
    }
    res = res * sign;

    if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
    return (int)res;
  }
}



public class ReverseInteger {

  public static void main(String[] args) {
    Solution4 sol = new Solution4();
    int x = sol.reverse(-321);
    System.out.println(x);
  }


}
