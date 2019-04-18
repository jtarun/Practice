package com.jtarun.practice.interviewbit.binarysearch;

class Solution3 {
  public int pow(int x, int n, int d) {
    if (x == 0) return 0;
    if (n == 0) return 1;
    if (n == 1) return (x)%d;

    long res;
    if (n % 1 == 1) {
      res = ((((long)x)%(long)d) * ((long)pow(x, n-1, d))%(long)d)%(long)d;
    } else {
      long y = ((long)pow(x,n/2, d)) % (long)d;
      res =  (y * y)%(long)d;
    }

    return (int)res;
  }
}


public class Pow {

  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    System.out.println(sol.pow(71045970,41535484, 64735492));
  }

}
