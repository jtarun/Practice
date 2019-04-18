package com.jtarun.practice.leetcode;

/**
 * Remove all occurrences of a particular element from a linked list.
 */
public class RemoveLinkedListElements {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public ListNode removeElements(ListNode head, int val) {
      if (head == null) return null;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode prev = dummy, cur = head;

      while(cur != null) {
        if (cur.val == val) {
          prev.next = cur.next;
        } else {
          prev = cur;
        }
        cur = cur.next;
      }
      return dummy.next;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(6);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(6);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    print(l1);
    print(sol.removeElements(l1, 6));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }

}
