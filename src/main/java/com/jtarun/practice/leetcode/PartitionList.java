package com.jtarun.practice.leetcode;

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 */
public class PartitionList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {

    public ListNode partition(ListNode head, int x) {
      ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0), t1 = dummy1, t2 = dummy2, t = head;

      while (t != null) {
        if (t.val < x) {
          t1.next = t;
          t1 = t;
        } else {
          t2.next = t;
          t2 = t;
        }
        t = t.next;
      }

      if (dummy1.next == null) {
        return dummy2.next;
      }

      t1.next = dummy2.next;
      t2.next = null;

      return dummy1.next;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(2);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(2);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    print(l1);
    print(sol.partition(l1, 3));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }


}
