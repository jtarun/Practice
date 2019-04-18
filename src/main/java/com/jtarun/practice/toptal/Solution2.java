package com.jtarun.practice.toptal;

import java.util.Arrays;

public class Solution2 {

  public int solution(int[] A) {
    int[] B = new int[A.length];
    for (int i = 0; i <A.length; i++) {
      B[i]= A[i];
    }

    Arrays.sort(B);
    int res = 0;

    int s = 0;
    for (int i = 0; i < A.length; i++) {
      if (match(A, B, s, i)) {
        res++;
      }
      s = i+1;
    }
    return res;
  }

  private boolean match(int[] A, int[] B, int s, int e) {
    Arrays.sort(A, s, e+1);
    for (int i = s; i <=e ; i++) {
      if (A[i] != B[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

  }

}
