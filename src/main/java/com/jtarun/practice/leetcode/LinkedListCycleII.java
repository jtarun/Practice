package com.jtarun.practice.leetcode;

/*
 * Return the node where cycle is found, otherwise return null.
 */
public class LinkedListCycleII {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public ListNode detectCycle(ListNode head) {
      if (head == null || head.next == null) {
        return null;
      }

      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (fast == slow) {
          break;
        }
      }

      if (slow != fast) {
        return null;
      }

      if (fast == head) {
        return head;
      }

      ListNode first = head, second = slow;
      while (first != second) {
        first = first.next;
        second = second.next;
      }

      return first;
    }

  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(6);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    l6.next = l1;
    ListNode res = sol.detectCycle(l1);
    System.out.println(res.val);
  }

}
