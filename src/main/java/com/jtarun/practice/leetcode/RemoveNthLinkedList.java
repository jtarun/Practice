package com.jtarun.practice.leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */
public class RemoveNthLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      this.next = null;
    }
  }

  private static class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      if ( n < 0) {
        return head;
      }

      int c = count(head);
      int t = c - n;
      if (c == 0 || t < 0) {
        return head;
      }

      if ( t == 0) {
         return head.next;
      }

      ListNode cur = head, prev = null;
      while (t-- > 0) {
        prev = cur;
        cur = cur.next;
      }

      prev.next = cur.next;

      return head;
    }

    private int count(ListNode head) {
      int count = 0;
      while (head != null) {
        head = head.next;
        count++;
      }
      return count;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);

    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;

    print(l1);
    print(sol.removeNthFromEnd(l1, 2));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }

}
