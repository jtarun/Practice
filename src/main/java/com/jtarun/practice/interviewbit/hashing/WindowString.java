package com.jtarun.practice.interviewbit.hashing;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public String minWindow(String S, String T) {

    Map<Character, Integer> freq = new HashMap<>();

    for (int i = 0; i < T.length(); i++) {
      char ch = T.charAt(i);
      int cnt = freq.computeIfAbsent(ch, k -> new Integer(0));
      freq.put(ch, cnt+1);
    }

    int i = 0, j = 0, cnt = 0, min = Integer.MAX_VALUE, start = 0;

    Map<Character, Integer> window = new HashMap<>();
    while (j < S.length()) {
      char ch = S.charAt(j);
      if (freq.containsKey(ch)) {
        int wcnt = window.computeIfAbsent(ch, k -> new Integer(0));
        window.put(ch, wcnt+1);
        if (wcnt < freq.get(ch))cnt++;
        if (cnt == T.length()) {

          while(i <= j) {
            if (j - i + 1 < min) {
              min = j - i + 1;
              start = i;
            }

            char iChar = S.charAt(i);
            i++;
            if (freq.containsKey(iChar)) {
              int icnt = window.get(iChar);
              window.put(iChar, icnt - 1);
              if (icnt == freq.get(iChar)) break;
            }
          }
          cnt--;
        }
      }
      j++;
    }
    if (min == Integer.MAX_VALUE) return "";

    return S.substring(start, start+min);
  }
}



public class WindowString {

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
  }

}
