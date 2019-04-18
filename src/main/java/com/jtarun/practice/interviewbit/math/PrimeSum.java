package com.jtarun.practice.interviewbit.math;

import java.util.ArrayList;

class Solution2 {

  public ArrayList<Integer> primesum(int a) {

    ArrayList<Integer> primes = seive(a-2);
    ArrayList<Integer> res = new ArrayList<>();
    int i = 0, j = primes.size()-1;

    while ( i <= j) {
      int sum = primes.get(i) + primes.get(j);
      if (sum == a) {
        res.add(primes.get(i));
        res.add(primes.get(j));
        break;
      } else if (sum > a) j--;
      else i++;
    }

    return res;
  }

  ArrayList<Integer> seive(int n) {
    ArrayList<Integer> primes = new ArrayList<>();
    int[] numbers = new int[n+1];

    for (int i = 2; i <= n; i++) {
      if (numbers[i] == 0) {
        primes.add(i);
        for (int j = 2*i; j <=n; j+= i) numbers[j] = 1;
      }
    }

    return primes;
  }

}



public class PrimeSum {
  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    sol.primesum(16777214).forEach(System.out::println);
  }
}
