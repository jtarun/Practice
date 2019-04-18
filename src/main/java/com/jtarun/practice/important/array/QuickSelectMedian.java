package com.jtarun.practice.important.array;


// O(n) algo to find median in a random array.
public class QuickSelectMedian {

  static int solve(int[] a) {
    int n = a.length;
    return solve(a, 0, n);
  }

  private static int solve(int[] a, int s, int e) {

    if (a.length == 1) return a[0];

    int lo = s + 1;
    int hi = e - 1;
    while (lo <= hi) {
      if (a[lo] < a[s]) {
        lo++;
      } else {
        swap(a, lo, hi);
        hi--;
      }
    }

    swap(a, s, hi);

    int mid = a.length / 2;

    if (mid == hi) {
      return a[mid];
    } else if ( mid < hi) {
      return solve(a, s, hi);
    } else {
      return solve(a, hi+1, e);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void main(String[] args) {
    int[] a = {19, 20, 1,2,3,5, 6, 7, 8};

    System.out.println(solve(a));
  }

}
