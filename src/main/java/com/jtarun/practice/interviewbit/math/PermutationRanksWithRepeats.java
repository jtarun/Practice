package com.jtarun.practice.interviewbit.math;

import java.util.HashMap;
import java.util.Map;

class Solution5 {
  int mod = 1000003;
  long[] fact;
  long[] infact;

  public int findRank(String a) {
    int n = a.length();
    fact = new long[n+1];
    infact = new long[n+1];

    fact(n);

    HashMap<Integer, Integer> h = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int c = (int)a.charAt(i);
      int cnt = h.getOrDefault(c, 0);
      h.put(c, cnt+1);
    }

    long res = 0;
    for (int i = 0; i < n - 1; i++) {
      int c = (int)a.charAt(i);
      long den = 1;
      for (Map.Entry<Integer, Integer> e : h.entrySet()) {
        den = (den * infact[e.getValue()]) % mod;
      }

      for (Map.Entry<Integer, Integer> e : h.entrySet()) {
        if (c > e.getKey()) {
          long factRem = (fact[n - i - 1] * e.getValue()) % mod;
          res += (factRem * den) % mod;
          res = res % mod;
        }
      }

      int cnt = h.getOrDefault(c, 0);
      if (cnt == 1) h.remove(c);
      else h.put(c, cnt-1);
    }


    return (int) ((res + 1) % mod);
  }

  long inverse(long n) {
     return (long)Math.pow(n, mod-2) % mod;
  }


  void fact(int n) {

    fact[0] = 1;
    infact[0] = 1;
    for (int i = 1; i <=n; i++) {
      fact[i] = (i * fact[i-1]) % mod;
      infact[i] = modExp(fact[i], mod-2);
    }
  }

  public long modExp(long xint, long yint) {
    long res = 1;
    long x = xint;
    long y = yint;
    while (y > 0) {
      if ((y & 1) == 1) {
        res = (res * x) % mod;
      }
      x = (x * x) % mod;
      y >>= 1;
    }
    return res;
  }

}



public class PermutationRanksWithRepeats {

  public static void main(String[] args) {
    Solution5 sol = new Solution5();
    System.out.println(sol.findRank("sadasdsasassasas")); //208526
    //System.out.println(sol.findRank("baa")); //208526
  }

}
