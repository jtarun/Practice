package com.jtarun.practice.interviewbit.heapsandmaps;

import java.util.HashMap;
import java.util.Map;

class Solution {
  int capacity = 0;
  class Node {
    int key;
    int val;
    Node left;
    Node right;
    Node(int key, int val) {
      this.key = key;
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  Node head = null;
  Node tail = null;
  Map<Integer, Node> map = new HashMap<>();

  public Solution(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!map.containsKey(key) || capacity <= 0) return -1;

    Node x = map.get(key);
    update(x);

    return x.val;
  }

  public void set(int key, int value) {
    if (capacity <= 0) return;

    if (capacity == map.size() && map.get(key) != tail) {
      map.remove(tail.key);
      if (map.size() == 0) {
        tail = head = null;
      } else {
        if (tail.left != null) tail.left.right = null;
        tail = tail.left;
        if (tail == null) tail = head;
      }
    }

    Node x = map.getOrDefault(key, new Node(key, value));
    x.val = value;
    map.put(key, x);
    update(x);
  }


  private void update(Node x) {
    if (head == null) {
      head = x;
      tail = x;
      return;
    }
    if (x == head) return;
    if (x == tail) tail = tail.left;
    if (tail == null) tail = x;

    if (x.left != null) x.left.right = x.right;
    if (x.right != null) x.right.left = x.left;
    x.left = null;
    x.right = head;
    head.left = x;
    head = x;


  }
}



public class LRU {
  public static void main(String[] args) {
    Solution sol = new Solution(1);
    sol.set(2,1);
    //sol.set(2,2);
    System.out.println(sol.get(2));
    sol.set(3,2);
   // sol.set(4,1);
    System.out.println(sol.get(2));
    System.out.println(sol.get(3));
  }

}
