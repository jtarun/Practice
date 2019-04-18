package com.jtarun.practice.toptal;

import java.util.HashSet;
import java.util.Set;

class Point2D{
  public int x;
  public int y;
}

class Slope {
  public int n;
  public int d;
  public int sign;

  public Slope(int n, int d, int sign) {
    this.n = n;
    this.d = d;
    this.sign = sign;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Slope slope = (Slope) o;

    if (n != slope.n) {
      return false;
    }
    if (d != slope.d) {
      return false;
    }
    return sign == slope.sign;
  }

  @Override
  public int hashCode() {
    int result = n;
    result = 31 * result + d;
    result = 31 * result + sign;
    return result;
  }
}

public class Solution {
  public int solution(Point2D[] A) {
    Set<Slope> slopes = new HashSet<>();

    for (int i = 0; i < A.length; i++) {
      int x = A[i].x;
      int y = A[i].y;
      int n = Math.abs(-x);
      int d = Math.abs(-y);
      int s = sign(-x) * sign(-y);
      Slope m = new Slope(n, d , s);
      slopes.add(m);
    }

    return slopes.size();
  }

  private int sign(int x) {
    if (x < 0) {
      return -1;
    }
    return 1;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    //sol.solution();
  }
}
