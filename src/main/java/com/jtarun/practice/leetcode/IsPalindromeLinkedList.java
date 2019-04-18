package com.jtarun.practice.leetcode;

/*
 * Given a singly linked list, determine if it is a palindrome.
 */
public class IsPalindromeLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
        return true;
      }

      ListNode slow = head, fast = head.next;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      ListNode first = head, second = reverse(slow.next);
      ListNode secondHead = second;
      while (second != null) {
        if (first.val != second.val) {
          return false;
        }
        first = first.next;
        second = second.next;
      }
      slow.next = reverse(secondHead);
      return true;
    }

    private ListNode reverse(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode prev = null, cur = head, nxt = cur.next;
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
