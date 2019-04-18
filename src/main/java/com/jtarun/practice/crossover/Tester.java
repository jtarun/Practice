package com.jtarun.practice.crossover;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {

  /**
   * Complete the function below.
   * DO NOT MODIFY anything outside this method.
   */
  static boolean[] twins(String[] a, String[] b) {
    boolean[] result = new boolean[a.length];

    for (int i = 0; i < a.length; i++) {
      result[i] =  twin(a[i], b[i]);
    }

    return result;
  }

  static boolean twin(String a, String b) {
    int n = a.length();
    int m = b.length();
    if (n != m) {
      return false;
    }

    List<Character> oddsA = new ArrayList<>();
    List<Character> oddsB = new ArrayList<>();
    List<Character> evensA = new ArrayList<>();
    List<Character> evensB = new ArrayList<>();

    boolean odd = true;
    for (int i = 0; i < n; i++) {
      if (odd) {
        oddsA.add(a.charAt(i));
        oddsB.add(b.charAt(i));
      } else {
        evensA.add(a.charAt(i));
        evensB.add(b.charAt(i));
      }
      odd = !odd;
    }

    Collections.sort(oddsA);
    Collections.sort(oddsB);
    Collections.sort(evensA);
    Collections.sort(evensB);

    return oddsA.equals(oddsB) && evensA.equals(evensB);
  }


  /**
   * DO NOT MODIFY THIS METHOD!
   */
/*  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine().trim());
    String[] a = new String[n];
    for(int i = 0; i < n; i++) {
      a[i] = in.nextLine();
    }

    int m = Integer.parseInt(in.nextLine().trim());
    String[] b = new String[m];
    for(int i = 0; i < m; i++) {
      b[i] = in.nextLine();
    }

    // call twins function
    boolean[] results = twins(a, b);

    for(int i = 0; i < results.length; i++) {
      System.out.println(results[i]? "Yes" : "No");
    }
  }*/


  public static void main(String[] args) throws IOException {
    String[] a = {"abcd", "cdab", "dcba"};
    String[] b = {"bcda", "abcd", "abcd"};

    // call twins function
    boolean[] results = twins(a, b);

    for(int i = 0; i < results.length; i++) {
      System.out.println(results[i]? "Yes" : "No");
    }
  }

}