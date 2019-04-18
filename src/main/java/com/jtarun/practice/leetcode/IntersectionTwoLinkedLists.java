package com.jtarun.practice.leetcode;

/*
 * Given a singly linked list, determine if it is a palindrome.
 */
public class IntersectionTwoLinkedLists {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      int n1 = count(headA);
      int n2 = count(headB);

      while (n1 > n2) {
        headA = headA.next;
        n1--;
      }

      while (n2 > n1) {
        headB = headB.next;
        n2--;
      }

      while (headA != null && headB != null && headA != headB) {
        headA = headA.next;
        headB = headB.next;
      }

      return (headA == null || headB == null) ? null : headA;
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

}
