package com.jtarun.practice.leetcode;

/** 148
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode mid = findMid(head);
      ListNode second = mid.next;
      mid.next = null;
      return merge(sortList(head), sortList(second));
    }

    private ListNode findMid(ListNode head) {
      ListNode slow = head, fast = head.next;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }

      return slow;
    }

    private ListNode merge(ListNode a, ListNode b) {
      ListNode dummy = new ListNode(0), t = dummy;
      while (a != null && b != null) {
        if (a.val <= b.val) {
          t.next = a;
          t = a;
          a = a.next;
        } else {
          t.next = b;
          t = b;
          b = b.next;
        }
      }

      if (a == null) {
        t.next = b;
      }

      if ( b == null) {
        t.next = a;
      }

      return dummy.next;
    }
  }
}
