package com.jtarun.practice.important.spatial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuadTree {

    Node root;
    int maxSize = 3;

    QuadTree(List<Point> ps) {
        this.root = construct(ps, 0, 0, 2L * Integer.MAX_VALUE);
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Node {
        int cx;
        int cy;
        long size;
        List<Point> points;
        List<Node> children;

        Node(int cx, int cy, long size) {
            this.cx = cx;
            this.cy = cy;
            this.size = size;
            points = new ArrayList<>();
            children = new ArrayList<>();
        }

        Node(List<Point> points, int cx, int cy, int size) {
            this.cx = cx;
            this.cy = cy;
            this.size = size;
            this.points = points;
            children = new ArrayList<>();
        }
    }

    Node construct(List<Point> ps, int cx, int cy, long size) {
        Node n = new Node(cx, cy, size);

        if (ps.size() <= maxSize) {
            n.points = ps;

        } else {

            int rsize = (int) (size / 2);
            Node child1 = construct(filter(ps, new Rectangle(cx - rsize, cy, rsize)), cx - rsize / 2, cy + rsize / 2, rsize);
            Node child2 = construct(filter(ps, new Rectangle(cx, cy, rsize)), cx + rsize / 2, cy + rsize / 2, rsize);
            Node child3 = construct(filter(ps, new Rectangle(cx - rsize, cy - rsize, rsize)), cx - rsize / 2, cy - rsize / 2, rsize);
            Node child4 = construct(filter(ps, new Rectangle(cx + rsize, cy - rsize, rsize)), cx + rsize / 2, cy - rsize / 2, rsize);

            n.children = Arrays.asList(child1, child2, child3, child4);
        }

        return n;
    }

    // visit neighbours within a dist
    List<Point> visitNeighbours(Point p, Node root, double dist) {

        if (!new Rectangle(root.cx, root.cy, root.size)
                .intersect(new Rectangle(p.x, p.y, (int) Math.ceil(dist * 2)))) return new ArrayList<>();

        if (root.children.isEmpty()) {
            return root.points.stream().filter(point -> distance(p, point) <= dist)
                    .collect(Collectors.toList());
        } else {

            List<Point> res = new ArrayList<>();
            root.children.forEach(child -> res.addAll(visitNeighbours(p, child, dist)));
            return res;
        }
    }

    private double distance(Point p, Point q) {
        return Math.sqrt(sq(p.x - q.x) + sq(p.y - q.y));
    }

    private double sq(double x) {
        return x * x;
    }

    private List<Point> filter(List<Point> ps, Rectangle r) {
        return ps.stream().filter(r::contains).collect(Collectors.toList());
    }

    private class Rectangle {
        int x;
        int y;
        long size;

        Rectangle(int x, int y, long size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        boolean contains(Point p) {
            return (p.x >= this.x && p.x <= this.x + size &&
                    p.y >= this.y && p.y <= this.y + size);
        }

        boolean intersect(Rectangle o) {

            //todo
            return true;
        }
    }


}
