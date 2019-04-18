package com.jtarun.practice.interviewbit.bitwise;

class Solution {
  public long reverse(long a) {
    long res = 0L;

    for (int i = 0; i<32; i++) {
      if ((a&(1<<i)) > 0) res |= (1L<<(31-i));
    }
    return res;
  }
}


public class ReverseBits {

  public static void main(String[] args) {
    Solution sol = new Solution();
    long n = 7;
    printBits(n);
    long r = sol.reverse(n);
    System.out.println();
    printBits(r);
  }

  static void printBits(long n) {
    for (long i = 31; i >= 0; i--) {
      System.out.print((n &(1<<i)) > 0 ? 1: 0);
    }
  }

}
