package com.jtarun.practice.leetcode;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    private static class Pair<T, W> {
      T ind;
      W node;
      Pair(T ind, W node) {
        this.ind = ind;
        this.node = node;
      }
    }

    public ListNode mergeKLists(ListNode[] lists) {
      Comparator<Pair<Integer, ListNode>> cmp = (p1, p2) -> {
        int c = Integer.compare(p1.node.val, p2.node.val);
        if (c == 0) c = -1;
        return c;
      };

      TreeSet<Pair<Integer, ListNode>> s = new TreeSet<>(cmp);
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          s.add(new Pair<>(i, lists[i]));
        }
      }
      ListNode dummy = new ListNode(0);
      ListNode t = dummy;
      while (!s.isEmpty()) {
        Pair<Integer, ListNode> p = s.pollFirst();
        t.next = p.node;
        t = t.next;
        lists[p.ind] = lists[p.ind].next;
        if (lists[p.ind] != null) {
          s.add(new Pair<>(p.ind, lists[p.ind]));
        }
      }

      return dummy.next;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;

    ListNode l4 = new ListNode(1);
    ListNode l5 = new ListNode(3);
    ListNode l6 = new ListNode(4);
    l4.next = l5;
    l5.next = l6;

    ListNode l7 = new ListNode(2);
    ListNode l8 = new ListNode(6);
    l7.next = l8;

    print(l1);
    print(l4);
    print(l7);
    print(sol.mergeKLists(new ListNode[]{l1, l4, l7}));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }
}
