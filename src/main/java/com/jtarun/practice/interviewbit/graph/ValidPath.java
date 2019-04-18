package com.jtarun.practice.interviewbit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Solution {

  class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      Point cmp = (Point) obj;
      return ((cmp.x == this.x) && (cmp.y == this.y));
    }

    public int hashCode() {
      return x * 101 + y;
    }
  }

  public String solve(int A, int B, int C, int D, ArrayList<Integer> E,
                      ArrayList<Integer> F) {

    HashSet<Point> invalid = new HashSet<>();

    for (int i = 0; i < E.size(); i++) {
      Point center = new Point(E.get(i), F.get(i));
      generateInvalid(center, D, invalid);
    }


    //(0,0) to (A, B)
    Set<Point> s =  new HashSet<>();
    Point src = new Point(0, 0);
    s.add(src);
    return solvebfs(src, new Point(A, B), invalid, new HashSet<Point>(), s) ? "YES" : "NO";

  }

  boolean solvebfs(Point src, Point dest, HashSet<Point> invalid, Set<Point> visited, Set<Point> stackSet) {
    Queue<Point> q = new LinkedList<>();
    q.add(src);
    HashSet<Point> added = new HashSet<>();
    while (!q.isEmpty()) {
       Point p = q.poll();
       System.out.println(" " + p.x + " "+ p.y + " ");
       if (p.equals(dest)) return true;
       ArrayList<Point> points = getValidNeighbours(p, dest, invalid, added, stackSet);
       for (Point point : points) {
         if (!added.contains(point)) {
           q.offer(point);
           added.add(point);
         }
       }
    }
    return false;
  }

  boolean solve(Point src, Point dest, HashSet<Point> invalid, Set<Point> visited,
                Set<Point> stackSet) {
    System.out.println(" " + src.x + " " + src.y + " ");
    ArrayList<Point> valids = getValidNeighbours(src, dest, invalid, visited, stackSet);
    boolean res = false;
    for (Point valid : valids) {
      stackSet.add(valid);
      res = solve(valid, dest, invalid, visited, stackSet);
      stackSet.remove(valid);
      visited.add(valid);
      if (res) {
        return true;
      }
    }
    return false;
  }

  ArrayList<Point> getValidNeighbours(Point src, Point dest, HashSet<Point> invalid, Set<Point> visited,
                                      Set<Point> stackSet) {
    ArrayList<Point> valids = new ArrayList<>();

    int x1 = src.x - 1;
    int y1 = src.y - 1;
    int x2 = src.x + 1;
    int y2 = src.y + 1;

    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (i < 0 || i > dest.x || j < 0 || j > dest.y) {
          continue;
        }
        if ( i == src.x && j == src.y) continue;
        Point p = new Point(i, j);
        if (invalid.contains(p) || visited.contains(p) || stackSet.contains(p)) {
          continue;
        }

        if (p.equals(dest)) valids.clear();
        valids.add(p);
      }
    }
    return valids;
  }

  void generateInvalid(Point c, int r, HashSet<Point> invalid) {

    int x1 = c.x - r;
    int y1 = c.y - r;
    int x2 = c.x + r;
    int y2 = c.y + r;

    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (contains(c, r, i, j)) {
          invalid.add(new Point(i, j));
        }
      }
    }

  }


  boolean contains(Point c, int r, int x, int y) {
    int xdiff = c.x - x;
    int ydiff = c.y - y;
    if (xdiff * xdiff + ydiff * ydiff > r * r) {
      return false;
    }

    return true;
  }
}


public class ValidPath {

  public static void main(String[] args) {
    Solution sol = new Solution();
/*    String res =
        sol.solve(82, 85, 9, 6,
            new ArrayList<>(Arrays.asList(65, 19, 38, 56, 19, 79, 74, 8, 56)),
            new ArrayList<>(Arrays.asList(25, 46, 54, 11, 63, 80, 37, 45, 52)));*/

    String res =
        sol.solve(37,38,9,2,
            new ArrayList<>(Arrays.asList(15, 11 ,7 ,31 ,3 ,18 ,18 ,12 ,31 )),
            new ArrayList<>(Arrays.asList(5 , 5,  0, 29, 2, 14, 1,  30, 18)));

    System.out.println(res);
  }
}
