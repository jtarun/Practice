package com.jtarun.practice.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

class Solution2 {
  public int removeDuplicates(ArrayList<Integer> a) {
    int i = 0, j = 0;
    int n = a.size();
    while (i < n && j < n) {

      a.set(i, a.get(j));
      while ( j < n && a.get(j).equals(a.get(i))) j++;
      i++;
    }

    j = n-1;
    while (j >= i) {
      a.remove(j);
      j--;
    }

    return a.size();
  }
}



public class RemoveDuplicates {

  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5000, 5000, 5000));
    sol.removeDuplicates(arr);
    arr.forEach(System.out::println);
  }

}
