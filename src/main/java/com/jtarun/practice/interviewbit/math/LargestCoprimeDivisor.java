package com.jtarun.practice.interviewbit.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution6 {
  int[] prime;

  public int cpFact(int A, int B) {
    int gcd = gcd(A, B);
    while (gcd != 1) {
      A = A/gcd;
      gcd = gcd(A, B);
    }
    return A;
  }

  int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a%b);
  }

  public int cpFact2(int A, int B) {

    int n = Math.max(A, B);
    prime = new int[n+1];
    seive(n);

    ArrayList<Integer> f1 = factors(A);
    ArrayList<Integer> f2 = factors(B);


    int res = 1;
    HashMap<Integer, Integer> h = new HashMap<>();
    for (int i = 0; i < f1.size(); i++) {
      int cnt = h.getOrDefault(f1.get(i), 0);
      h.put(f1.get(i), cnt+1);
    }

    for (int i = 0; i < f2.size(); i++) {
      h.remove(f2.get(i));
    }

    for (Map.Entry<Integer, Integer> e : h.entrySet()) {
      res *= Math.pow(e.getKey(), e.getValue());
    }
    return res;
  }


  ArrayList<Integer> factors(int n) {
    ArrayList<Integer> res = new ArrayList<>();
    if (n <=1) return res;

    for (int i = 2; i <= n; i++) {
      if (n % i == 0) {
        if (isPrime(i)) {
          while (n % i == 0) {
            n = n/i;
            res.add(i);
          }
        }
      }
      if ( n <= 1) break;
    }
    return res;
  }

  void seive(int n) {

    prime[0] = 1;
    prime[1] = 1;

    for (int i = 2; i <= n; i++) {
      if (prime[i] == 0) {
        for (int j = 2 * i ; j <=n; j+=i)prime[j] = 1;
      }
    }
  }

  boolean isPrime(int n) {
    return  (prime[n] == 0);
  }
}



public class LargestCoprimeDivisor {

  public static void main(String[] args) {
    Solution6 sol = new Solution6();
    System.out.println(sol.cpFact(90, 47));
  }

}
