package com.jtarun.practice.interviewbit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution7 {
  class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public void solve(ArrayList<ArrayList<Character>> a) {
    int n = a.size();
    if (n == 0) return;
    int m = a.get(0).size();
    if ( m== 0) return;

    ArrayList<Point> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char e = a.get(i).get(j);
        if (e == 'O') {
          if (captured(a, i, j, n, m)) points.add(new Point(i, j));
        }
      }
    }

    points.forEach(p -> a.get(p.x).set(p.y, 'X'));
  }


  boolean captured(ArrayList<ArrayList<Character>> a, int i, int j, int n, int m) {
    Queue<Point> q = new LinkedList<>();
    Point root = new Point(i, j);
    q.add(root);
    boolean[][] v = new boolean[n][m];
    v[i][j] = true;
    while (!q.isEmpty()) {
      Point p = q.poll();
      if (p.x == 0 || p.y == 0 || p.x == n-1 || p.y == m-1) {
        if (a.get(p.x).get(p.y) == 'O') return false;
        else continue;
      }
      if (a.get(i).get(j) == 'X') continue;

      validateAndAdd(a, p.x-1, p.y, v, q);
      validateAndAdd(a, p.x+1, p.y, v, q);
      validateAndAdd(a, p.x, p.y-1, v, q);
      validateAndAdd(a, p.x, p.y+1, v, q);

    }
    return true;
  }


  void validateAndAdd(ArrayList<ArrayList<Character>> a, int i, int j,
                      boolean[][] v, Queue<Point> q) {
    boolean valid = !v[i][j] && (a.get(i).get(j) == 'O');
    v[i][j]= true;
    if (valid) q.add(new Point(i, j));
  }
}




public class CaptureRegions {
  public static void main(String[] args) {
    String[] t = {"XOX", "XOX", "XOX" };
    ArrayList<ArrayList<Character>> a = new ArrayList<>();
    for (String s :  t) {
      ArrayList<Character> arr = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        arr.add(c);
      }
      a.add(arr);
    }

    Solution7 sol = new Solution7();
    sol.solve(a);

    a.forEach(arr -> {
      arr.forEach(System.out::print);
      System.out.println();
    });

  }

}
