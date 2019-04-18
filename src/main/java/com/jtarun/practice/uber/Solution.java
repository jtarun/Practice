package com.jtarun.practice.uber;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
  class Pair {
    int ind;
    long val;

    Pair(int ind, long val) {
      this.ind = ind;
      this.val = val;
    }
  }

  //BufferedReader read;
  //BufferedWriter write;
  public static void main(String args[]) throws Exception {
    new Solution().init("6");
  }

  void init(String name) throws Exception {
    BufferedReader read = rf(name + ".txt");


    int[] inp = sa(read.readLine());
    int n = inp[0];
    int k = inp[1];

    //System.out.println(t);
    ArrayList<Integer> time = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      int t = i(read.readLine());
      time.add(t);
    }

    Collections.sort(time);

    Comparator<Pair> cmp = (p1, p2) -> {
      int c = Long.compare(p1.val, p2.val);
      if (c == 0) {
        c = Integer.compare(p1.ind, p2.ind);
      }
      return c;
    };
    //Comparator.<Pair>comparingLong(p -> p.val).thenComparingInt(p -> p.ind);

    TreeSet<Pair> sum = new TreeSet<>(cmp);
    int i = 0;
    for (; i < k; i++) {
      sum.add(new Pair(i, time.get(i)));
    }

    long res = 0;
    while (i < n) {
      Pair p = sum.first();
      long r = p.val + time.get(p.ind);
      if (i == n - 1) {
        res = r;
        break;
      }
      sum.remove(p);
      sum.add(new Pair(p.ind, r));
      i++;
    }
    System.out.println(res);

    read.close();
  }

  int i(String s) {
    return Integer.parseInt(s.trim());
  }

  long l(String s) {
    return Long.parseLong(s.trim());
  }

  int[] sa(String s1) {
    String s[] = s1.split(" ");
    int p[] = new int[s.length];
    for (int i = 0; i < s.length; i++) {
      p[i] = Integer.parseInt(s[i]);
    }
    return p;
  }

  long[] la(String s) {
    String s1[] = s.split(" ");
    long la[] = new long[s1.length];
    for (int i = 0; i < s1.length; i++) {
      la[i] = l(s1[i]);
    }
    return la;
  }

  static BufferedWriter wf(String s) throws Exception {
    return new BufferedWriter(new FileWriter(new File(s)));
  }

  BufferedReader rf(String s) throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(s).getFile());
    return new BufferedReader(new FileReader(file));
  }

  static BufferedReader ri() throws Exception {
    return new BufferedReader(new InputStreamReader(System.in));
  }
}
