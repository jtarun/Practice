package com.jtarun.practice.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
  class Pair {
    int x;
    int y;
    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

    ArrayList<Pair> pa = new ArrayList<>();

    int n = arrive.size();

    for (int i  = 0; i < n; i++) {
      int x = arrive.get(i);
      int y = depart.get(i);
      pa.add(new Pair(x, 1));
      pa.add(new Pair(y, 0));
    }

    Comparator<Pair> cmp = (p1, p2) -> {
      int c = Integer.compare(p1.x, p2.x);
      if (c != 0) return c;
      return Integer.compare(p1.y, p2.y);
    };

    Collections.sort(pa, cmp);

    int open = 0;

    for (int i = 0; i < pa.size(); i++) {
      Pair p = pa.get(i);
      if (p.y == 1) open++;
      else open--;
      if (open > K) return false;
    }

    return true;
  }
}




public class HotelBooking {

  public static void main(String[] args) {
    Solution sol = new Solution();

    ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1,2,3));
    ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2,3,4));

    sol.hotel(arrive, depart, 1);
  }

}
