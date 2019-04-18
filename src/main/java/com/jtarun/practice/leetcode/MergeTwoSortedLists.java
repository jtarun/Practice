package com.jtarun.practice.leetcode;

/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Examples :
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

      ListNode dummy = new ListNode(0);
      ListNode t = dummy;
      while (l1 != null && l2 != null) {

        if (l1.val <= l2.val) {
          t.next = l1;
          l1 = l1.next;
        } else {
          t.next = l2;
          l2 = l2.next;
        }
        t = t.next;
      }

      if (l1 != null) {
        t.next = l1;
      }
      if (l2 != null) {
        t.next = l2;
      }

      return dummy.next;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(4);
    l1.next = l2;
    l2.next = l3;

    ListNode l4 = new ListNode(1);
    ListNode l5 = new ListNode(3);
    ListNode l6 = new ListNode(4);
    l4.next = l5;
    l5.next = l6;

    Solution sol = new Solution();
    print(l1);
    print(l4);
    print(sol.mergeTwoLists(l1, l4));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }


}
