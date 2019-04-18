package com.jtarun.practice.leetcode;

/*
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class DetectCycleLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) {
        return false;
      }

      ListNode slow = head, fast = head.next;
      while (slow != fast && fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      return slow == fast;
    }
  }

}
