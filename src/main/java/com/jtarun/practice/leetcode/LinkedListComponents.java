package com.jtarun.practice.leetcode;

import java.util.HashSet;
import java.util.Set;


/* 817
 * We are given head, the head node of a linked list containing unique integer values.
 * We are also given the list G, a subset of the values in the linked list.
 * Return the number of connected components in G, where two values are connected if they appear
 * consecutively in the linked list.
 */
public class LinkedListComponents {

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public int numComponents(ListNode head, int[] G) {
      if (head == null) {
        return 0;
      }
      Set<Integer> g = new HashSet<>();
      for (int a : G) {
        g.add(a);
      }

      ListNode t = head;
      boolean started = false;
      int cnt = 0;
      while (t != null) {
        if (g.contains(t.val)) {
          if (!started) {
            started = true;
            cnt++;
          }
        } else {
          started = false;
        }
        t = t.next;
      }

      return cnt;
    }
  }

}
