package com.jtarun.practice.leetcode;

/*
 * Given a singly linked list, determine if it is a palindrome.
 */
public class OddEvenLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {

    public ListNode oddEvenList(ListNode head) {
      if (head == null) return null;
      ListNode dummy1 = new ListNode(0);
      ListNode dummy2 = new ListNode(0);

      ListNode t1 = dummy1, t2 = dummy2, t = head;
      boolean odd = true;
      while ( t != null) {
        if (odd) {
          t1.next = t;
          t1 = t;
        } else {
          t2.next = t;
          t2 = t;
        }
        t = t.next;
        odd = !odd;
      }

      t1.next = dummy2.next;
      t2.next = null;
      return dummy1.next;
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
    print(sol.oddEvenList(l1));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }


}
