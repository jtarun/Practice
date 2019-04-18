package com.jtarun.practice.interviewbit.backtracking;

import java.util.ArrayList;

class Solution2 {
  public ArrayList<ArrayList<String>> partition(String a) {

    ArrayList<ArrayList<String>> out = new ArrayList<>();
    ArrayList<String> temp = new ArrayList<>();
    gen(a, 0, temp, out);
    return out;
  }


  private void gen(String a, int ind, ArrayList<String> temp, ArrayList<ArrayList<String>> out) {
    if (ind > a.length()) return;
    if (ind == a.length()) {
      out.add(new ArrayList<>(temp));
      return;
    }

    for (int i = ind; i < a.length(); i++) {
      if (isPalindrome(a, ind, i)) {
        temp.add(a.substring(ind, i + 1));
        gen(a, i + 1, temp, out);
        temp.remove(temp.size()-1);
      }
    }

  }


  private boolean isPalindrome(String a, int i, int j) {
    while ( i < j) {
      if (a.charAt(i) != a.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }
}


public class PalindromePartitioning {

  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    sol.partition("efe")
      .forEach(list -> {
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();
      });
  }
}
