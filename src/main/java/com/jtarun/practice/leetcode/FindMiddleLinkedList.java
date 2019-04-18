package com.jtarun.practice.leetcode;

/*
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 */
public class FindMiddleLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public ListNode middleNode(ListNode head) {
      if (head == null || head.next == null) return head;

      ListNode fast = head, slow = head;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      return slow;
    }
  }

}
