package com.jtarun.practice.interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution2 {
  class Pair {
    int sum;
    int x;
    int y;

    Pair(int sum, int x, int y) {
      this.sum = sum;
      this.x = x;
      this.y = y;
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

      if (sum != pair.sum) {
        return false;
      }
      if (x != pair.x) {
        return false;
      }
      return y == pair.y;
    }

    @Override
    public int hashCode() {
      int result = sum;
      result = 31 * result + x;
      result = 31 * result + y;
      return result;
    }
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    Collections.sort(A, Collections.reverseOrder());
    Collections.sort(B, Collections.reverseOrder());

    ArrayList<Integer> res = new ArrayList<>();
    Comparator<Pair> cmp = (p1, p2) -> {
      int c = Integer.compare(p2.sum, p1.sum);
      if (c != 0) {
        return c;
      }
      return -1;
    };
    Set<Pair> done = new HashSet<>();
    TreeSet<Pair> h = new TreeSet<>(cmp);
    Pair pair = new Pair(A.get(0) + B.get(0), 0, 0);
    h.add(pair);
    int n = A.size();
    while (res.size() < n) {
      Pair p = h.pollFirst();
      if (!done.contains(p)) {
        res.add(p.sum);
        if (p.x + 1 < n) {
          h.add(new Pair(A.get(p.x + 1) + B.get(p.y), p.x + 1, p.y));
        }
        if (p.y + 1 < n) {
          h.add(new Pair(A.get(p.x) + B.get(p.y + 1), p.x, p.y + 1));
        }
        done.add(p);
      }
    }
    return res;
  }
}


public class NMaxPairCombinations {

  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28));
    ArrayList<Integer> b = new ArrayList<>(Arrays.asList(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43));
    sol.solve(a, b).forEach(x -> System.out.print(x + " "));
  }

}
