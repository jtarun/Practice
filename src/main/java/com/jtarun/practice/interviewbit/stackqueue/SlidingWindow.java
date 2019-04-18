package com.jtarun.practice.interviewbit.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
  // DO NOT MODIFY THE LIST
  public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {


    Deque<Integer> d = new LinkedList<>();
    ArrayList<Integer> max = new ArrayList<>();
    ArrayList<Integer> res = new ArrayList<>();

    for (int i  = 0;  i < a.size(); i++) {
      while(d.size() > 0 && (i - d.getFirst() + 1 > b)) d.removeFirst();
      while(d.size() > 0 && (i - d.getLast() + 1 > b)) d.removeLast();
      if (d.size() == 0) {
        d.addFirst(i);
      } else if (a.get(d.getFirst()) <= a.get(i) ) {
        d.addFirst(i);
      } else {

        d.addLast(i);
      }
      max.add(d.getFirst());
    }

    for (int i = b-1; i < a.size(); i++) {
      res.add(a.get(max.get(i)));
    }

    return res;

  }
}


public class SlidingWindow {

  public static void main(String[] args) {
    Solution sol = new Solution();
    List<Integer>  l = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
    ArrayList<Integer> a = new ArrayList<>();
    a.addAll(l);
    sol.slidingMaximum(a, 2).forEach(x -> System.out.print(x + " "));
  }
}
