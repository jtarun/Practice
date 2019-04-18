package com.jtarun.practice.important.fenwick;

public class Fenwick {
  private int[] bit;

  Fenwick(int[] a) {
    bit = new int[a.length + 1];
    for (int i = 0; i < a.length; i++) {
      update(i+1, a[i]);
    }
  }

  void update(int i, int val) {
    int n = bit.length;
    while (i < n) {
      bit[i] += val;
      i += i & (-i);
    }
  }

  int sum(int i) {
    if (i < 0) {
      return 0;
    }

    int sum = 0;
    while (i > 0) {
      sum += bit[i];
      i -= i & (-i);
    }
    return sum;
  }

  int rangeSum(int i, int j) {
    return sum(j) - sum(i - 1);
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 9, 6};
    Fenwick fenwick = new Fenwick(a);

    int sum = fenwick.rangeSum(2, 4);
    System.out.println(sum);

    fenwick.update(2, 12);
    System.out.println(fenwick.rangeSum(2, 4));
  }

}
