package com.jtarun.practice.interviewbit.bitwise;

class Solution2 {
  public int divide(int dividend, int divisor) {
    long num = Math.abs((long)dividend), den = Math.abs((long)divisor);
    boolean sign = (dividend < 0) ^ (divisor < 0);

    if (num < den) return 0;

    long ans = 0L, val = 0L;
    for (int i = 31;i>=0; i--) {
      if((val + (den<<i)) <= num) {
        val = val + (den << i);
        ans |= 1L<<i;
      }
    }

    if (sign) ans = -ans;
    return ((ans < Integer.MIN_VALUE) || (ans > Integer.MAX_VALUE)) ?
        Integer.MAX_VALUE : (int)ans;
  }

}



public class Divide {
  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    int ans = sol.divide(-2147483648, -1);
    System.out.println(ans);
  }
}
