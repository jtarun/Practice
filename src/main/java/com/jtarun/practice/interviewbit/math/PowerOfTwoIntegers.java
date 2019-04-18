package com.jtarun.practice.interviewbit.math;

class Solution3 {
  public boolean isPower(int a) {
    if (a == 1) return true;

    int sqrt = (int)Math.sqrt(a);


    for (int i = 2; i <= sqrt; i++) {

      for (int j = 2; j <= sqrt; j++) {
        int power = (int)Math.pow(i, j);
        if (power == a) return true;
        if (power > a) break;
      }

    }

    return false;
  }
}



public class PowerOfTwoIntegers {

  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    System.out.println(sol.isPower(536870912));
  }

}
