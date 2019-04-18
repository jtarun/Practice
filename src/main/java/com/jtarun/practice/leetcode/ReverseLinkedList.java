package com.jtarun.practice.leetcode;


public class ReverseLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode cur = head, prev = null, nxt = head.next;
      while (cur != null) {
        cur.next = prev;
        prev = cur;
        cur = nxt;
        if (nxt != null) {
          nxt = nxt.next;
        }
      }
      return prev;
    }
  }
}
