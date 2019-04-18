package com.jtarun.practice.interviewbit.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution5 {
  public int ladderLength(String start, String end, ArrayList<String> dictV) {

    Set<String> dict = new HashSet<>();
    dict.addAll(dictV);
    if (!dict.contains(start) || !dict.contains(end)) return -1;
    if (start.equals(end)) return 0;

    Queue<String> q = new LinkedList<>();
    q.add(start);
    Set<String> visited = new HashSet<>();
    visited.add(start);
    int level = -1;
    int n = start.length();
    while (!q.isEmpty()) {
      level++;
      int cnt = q.size();
      while (cnt-- > 0) {
        String p = q.poll();
        if (p.equals(end)) return level+1;

        for ( int i = 0; i < n; i++ ) {
          int c = p.charAt(i);
          for (char k = 'a'; k <= 'z'; k++) {
            if (k != c) {
              String x = p.substring(0, i) + k + p.substring(i+1, n);
              if (dict.contains(x) && !visited.contains(x)) {
                visited.add(x);
                q.add(x);
              }
            }
          }
        }
      }
    }
    return -1;
  }
}


public class WordLadder1 {
}
