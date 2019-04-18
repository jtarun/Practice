package com.jtarun.practice.interviewbit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution6 {

  public ArrayList<ArrayList<String>> findLadders(String start, String end,
                                                  ArrayList<String> dict) {

    Set<String> uniqueDict = new HashSet<>();
    uniqueDict.addAll(dict);
    dict.clear();
    dict.addAll(uniqueDict);

    int n = dict.size();
    int[][] g = new int[n+1][n+1];
    int s = -1, e = -1;
    for (int i = 0; i < n; i++) {
      if (start.equals(dict.get(i))) s = i;
      if (end.equals(dict.get(i))) e = i;
      for (int j = i+1; j < n; j++) {
        if (isAdjacent(dict.get(i), dict.get(j))) {
          g[i][j] = 1;
          g[j][i] = 1;
        }
      }
    }

    ArrayList<ArrayList<String>> res = new ArrayList<>();
    if (s == -1 ||  e==-1)  return res;

    if (s == e) {
      res.add(new ArrayList<>(Arrays.asList(dict.get(e))));
      return res;
    }

    Queue<Integer> q = new LinkedList<>();
    HashMap<Integer, ArrayList<Integer>> parents = new HashMap<>();
    parents.put(s, new ArrayList<>());
    q.add(s);
    int[] visited = new int[n];
    visited[s] = 1;
    int level = 2;
    boolean found = false;
    while (!q.isEmpty()) {

      int cnt = q.size();
      while (cnt-- > 0) {
        int p = q.poll();

        for (int i = 0; i < n; i++) {
          if ((visited[i] == level || visited[i] == 0) && g[p][i] == 1){
            parents.computeIfAbsent(i, k -> new ArrayList<>()).add(p);
          }

          if (visited[i] == 0 && g[p][i] == 1) {
            visited[i] = level;
            q.add(i);
            if (i == e) {
              found = true;
            }
          }
        }
      }
      if (found) break;
      level++;
    }
    if (!found) return res;

    Queue<ArrayList<Integer>> paths = new LinkedList<>();
    paths.add(new ArrayList<>(Arrays.asList(e)));
    boolean srcFound = false;
    while (!srcFound) {
      int cnt = paths.size();
      while (cnt-- > 0) {
        ArrayList<Integer> path = paths.poll();
        int lastNode = path.get(0);
        ArrayList<Integer> parentNodes = parents.get(lastNode);
        for (int i = 0; i < parentNodes.size(); i++) {
          ArrayList<Integer> childPath = new ArrayList<>();
          childPath.add(parentNodes.get(i));
          childPath.addAll(new ArrayList<>(path));
          paths.add(childPath);
          if (parentNodes.get(i) == s) srcFound = true;
        }
      }
    }

    int size = paths.size();

    for (int i = 0; i < size; i++) {
      ArrayList<String> arr = new ArrayList<>();
      ArrayList<Integer> path = paths.poll();
      if (path.get(0) == s) {
        for (int j = 0; j < path.size(); j++) arr.add(dict.get(path.get(j)));
        res.add(arr);
      }
    }
    return res;
  }

  boolean isAdjacent(String a, String b) {

    int d = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) d++;
      if (d > 1) return false;
    }
    return true;
  }

}



public class WordLadder2 {
  public static void main(String[] args) {
    Solution6 sol = new Solution6();
    sol.findLadders("bbaa", "babb", new ArrayList<>(Arrays.asList("baba", "abba", "aaba", "bbbb",
        "abaa", "abab", "aaab", "abba", "abba", "abba", "bbba", "aaab", "abaa", "baba", "baaa", "bbaa", "babb")))
        .forEach(x -> {
      x.forEach( e -> System.out.print(e + ","));
      System.out.println();
    });
  }
}
