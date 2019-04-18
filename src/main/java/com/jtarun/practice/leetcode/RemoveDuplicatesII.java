package com.jtarun.practice.leetcode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 */
public class RemoveDuplicatesII {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {

    public ListNode deleteDuplicates(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode dummy = new ListNode(0), t = head, k = dummy;

      while (t != null) {
        if (t.next == null) {
          k.next = t;
          t = null;
        } else {
          ListNode p = t.next;
          int cnt = 0;
          while (p != null && p.val == t.val) {
            p = p.next;
            cnt++;
          }
          if (cnt == 0) {
            k.next = t;
            k = t;
            k.next = null;
          }
          t = p;
        }

      }

      return dummy.next;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(3);
    ListNode l5 = new ListNode(4);
    ListNode l6 = new ListNode(4);
    ListNode l7 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    l6.next = l7;
    print(l1);
    print(sol.deleteDuplicates(l1));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }


}
