package com.jtarun.practice.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution4 {
  public int books(ArrayList<Integer> a, int b) {
    int lo = Collections.max(a), hi = Integer.MAX_VALUE;
    int res = -1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      int students = students(a, mid);
      //System.out.println(lo + " " + hi + " " + students);
      if (students <= b) {
        res = mid;
        hi = mid - 1;
      } else if (students > b) {
        lo = mid+1;
      }
    }

    return res;
  }

  int students(ArrayList<Integer> a, int n) {
    int cnt = 1, cur_page = 0;
    for ( int x : a) {
      if (cur_page + x <= n) {
        cur_page += x;
      } else {
        cnt++;
        cur_page = x;
      }
    }
    return cnt;
  }

}





public class AllocateBooks {

  public static void main(String[] args) {
    Solution4 sol = new Solution4();
/*    int res1 = sol.books(new ArrayList<>(Arrays.asList(97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67,
        72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24)), 26);*/
    int res = sol.books(new ArrayList<>(Arrays.asList(31, 14, 19, 75)), 12);
    System.out.println(res);
  }

}
