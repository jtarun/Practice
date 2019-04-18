package com.jtarun.practice.leetcode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 */
public class ReorderList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {

    public void reorderList(ListNode head) {
      if (head == null || head.next == null) {
        return;
      }

      ListNode slow = head, fast = head.next;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }

      ListNode second = reverse(slow.next), first = head;
      slow.next = null;

      while (second != null) {
        ListNode temp1 = first.next, temp2 = second.next;
        first.next = second;
        second.next = temp1;
        first = temp1;
        second = temp2;
      }

      return;
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

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(2);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(2);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    print(l1);
    sol.reorderList(l1);
    print(l1);
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }


}
