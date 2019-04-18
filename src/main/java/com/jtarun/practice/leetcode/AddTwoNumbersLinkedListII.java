package com.jtarun.practice.leetcode;


/** 445
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class AddTwoNumbersLinkedListII {

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  // Use two stacks if linked list cannot be modified.

  private static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode r1 = reverse(l1);
      ListNode r2 = reverse(l2);

      ListNode dummy = new ListNode(0), t = dummy;
      int carry = 0;
      while ((r1 != null) || (r2 != null)) {
        int sum = carry;
        if (r1 != null) {
          sum += r1.val;
          r1 = r1.next;
        }
        if (r2 != null) {
          sum += r2.val;
          r2 = r2.next;
        }
        carry = sum / 10;
        ListNode n = new ListNode(sum % 10);
        t.next = n;
        t = n;
      }

      if (carry != 0) {
        t.next = new ListNode(carry);
      }

      return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode prev = null, cur = head, nxt = head.next;
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
