package com.jtarun.practice.important.spatial;

import java.util.List;

public class KDTree {

  Node root;
  int maxPoints = 3;

  KDTree(Point[] points) {
    this.root = construct(points, 0 , points.length);
  }

  Node construct(Point[] ps, int s, int e) {
    return null;
  }

  class Node {
    int dimension;
    int splitValue;
    List<Point> points;
    List<Node> children;

    Node(int dimension, int splitValue) {
      this.dimension = dimension;
      this.splitValue = splitValue;
    }

    Node(int dimension, int splitValue, List<Point> points) {
      this.dimension = dimension;
      this.splitValue = splitValue;
      this.points = points;
    }
  }

  class Point {
    int dim;
    int[] vals;

    Point(int[] vals) {
      dim = vals.length;
      this.vals = vals;
    }
  }

}
