package com.jtarun.practice.toptal;

import java.util.Arrays;

public class Test1 {


  public int solution(int[] A, int[] B, int[] C) {
    Arrays.sort(A);
    Arrays.sort(B);
    Arrays.sort(C);
    int n1 = A.length;
    int n2 = B.length;
    int n3 = C.length;
    long res = 0;

    for (int i = 0; i < n1; i++) {

      int x = find(B, 0, n2, A[i]);

      for (int j = x; j < n2; j++) {
        int y = find(C, 0, n3, B[j]);

        if (y > n3) {
          break;
        }

        int r = n3 - y;
        res += r;
      }

    }

    int ans = 0;
    if (res > 1000000000L) {
      ans = -1;
    } else {
      ans = (int)res;
    }
    return ans;
  }

  private int find(int[] A, int b, int e, int k) {
    int x = Arrays.binarySearch(A, b, e, k);
    if (x >= 0) {
      x++;
    } else {
      x = -(x + 1);
    }
    return x;
  }


  public static void main(String[] args) {
    Test1 test = new Test1();
    int[] A = {29, 29};
    int[] B = {61, 61};
    int[] C = {70, 70};
    int ans = test.solution(A, B, C);
    System.out.println(ans);
  }
}
