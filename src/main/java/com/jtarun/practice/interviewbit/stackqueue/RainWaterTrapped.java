package com.jtarun.practice.interviewbit.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {

  class Pair {
    int l;
    int r;
    Pair(int l, int r) {
      this.l = l;
      this.r = r;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Pair pair = (Pair) o;

      if (l != pair.l) {
        return false;
      }
      return r == pair.r;
    }

    @Override
    public int hashCode() {
      int result = l;
      result = 31 * result + r;
      return result;
    }
  }

  // DO NOT MODIFY THE LIST
  public int trap(final List<Integer> a) {

    int last = -1;
    int res = 0;
    Set<Pair> pairs = new HashSet<>();


    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) == 0) {
      } else if (last == -1) {
        last = i;
      } else if (a.get(last) <= a.get(i)) {
        pairs.add(new Pair(last, i));
        last = i;
      }
    }
    last = -1;
    for (int i = a.size() - 1; i >= 0; i--) {
      if (a.get(i) == 0) {
      } else if (last == -1) {
        last = i;
      } else if (a.get(i) >= a.get(last)) {
        pairs.add(new Pair(i, last));
        last = i;
      }
    }


    for (Pair pair : pairs) {

      int sum = 0;
      for (int i = pair.l +1; i < pair.r; i++) {
        sum += a.get(i);
      }
      res += Math.min(a.get(pair.l), a.get(pair.r)) * (pair.r - pair.l - 1) - sum;
    }

    return res;
  }
}

public class RainWaterTrapped {

  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    int t = sol.trap(new ArrayList<>(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1)));
    System.out.println(t);
  }

}
