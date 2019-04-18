package com.jtarun.practice.leetcode;

public class DeleteDuplicatesLinkedList {
  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }

  private static class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode t = head;
      while (t != null) {
        ListNode n = t.next;
        while(n != null && n.val == t.val) {
          t.next = n.next;
          n = n.next;
        }
        t = n;
      }

      return head;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(1);
    ListNode l3 = new ListNode(2);
    l1.next = l2;
    l2.next = l3;
    print(sol.deleteDuplicates(l1));

    ListNode l4 = new ListNode(3);
    ListNode l5 = new ListNode(3);
    l3.next = l4;
    l4.next = l5;
    print(sol.deleteDuplicates(l1));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }
}
