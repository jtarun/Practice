package com.jtarun.practice.interviewbit.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution4 {
  class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Point point = (Point) o;

      if (x != point.x) {
        return false;
      }
      return y == point.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }
  }

  public int knight(int N, int M, int x1, int y1, int x2, int y2) {
    int level = -1;
    Point src = new Point(x1, y1);
    Point dest = new Point(x2, y2);

    Queue<Point> q = new LinkedList<>();
    q.add(src);
    Set<Point> visited = new HashSet<>();
    visited.add(src);
    while (!q.isEmpty()) {
      level++;
      int cnt = q.size();
      while (cnt-- > 0) {
        Point p = q.poll();
        if (p.x == x2 && p.y == y2) {
          return level;
        }

        ArrayList<Point> points = getValidPoints(p, N, M);
        for (Point x : points) {
          if (!visited.contains(x)) {
            q.add(x);
            visited.add(x);
          }
        }
      }
    }
    return -1;
  }

  ArrayList<Point> getValidPoints(Point p, int n, int m) {
    ArrayList<Point> res = new ArrayList<>();

    int x = p.x;
    int y = p.y;

    if (x-2 > 0 && y + 1 <= m ) res.add(new Point(x-2, y+1));
    if (x-2 > 0 && y - 1 > 0 ) res.add(new Point(x-2, y-1));
    if (x-1 > 0 && y-2 > 0 ) res.add(new Point(x-1, y-2));
    if (x+1 <= n && y-2 > 0 ) res.add(new Point(x+1, y-2));
    if (x+2 <= n && y - 1 > 0) res.add(new Point(x+2, y-1));
    if (x+2 <= n && y + 1 <= m ) res.add(new Point(x+2, y+1));
    if (x-1 > 0 && y + 2 <= m ) res.add(new Point(x-1, y+2));
    if (x+1 <= n && y + 2 <= m ) res.add(new Point(x+1, y+2));

    return res;
  }
}



public class KnightChessBoard {
  public static void main(String[] args) {
    Solution4 sol = new Solution4();
    int res = sol.knight(2, 20, 1, 18, 1, 5);
    System.out.println(res);
  }

}
