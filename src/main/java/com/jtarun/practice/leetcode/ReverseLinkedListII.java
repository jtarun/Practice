package com.jtarun.practice.leetcode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      if (m >= n) {
        return head;
      }

      ListNode prev = null, cur = head;
      int cnt1 = m;
      while (--cnt1 > 0 && cur != null) {
        prev = cur;
        cur = cur.next;
      }

      ListNode last = prev, nxt = cur.next, mth = cur;
      prev = null;
      int cnt2 = n-m+1;
      while (cnt2-- > 0 && cur != null) {
        cur.next = prev;
        prev = cur;
        cur = nxt;
        if (nxt != null) {
          nxt = nxt.next;
        }
      }

      if (last != null) {
        last.next = prev;
      }

      ListNode newHead = head;
      if (m == 1) {
        newHead = prev;
      }

      mth.next = cur;

      return newHead;
    }
  }
}
