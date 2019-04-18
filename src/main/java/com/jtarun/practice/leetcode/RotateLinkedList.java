package com.jtarun.practice.leetcode;

/** 61
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 */
public class RotateLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {

    // Alternate Solution is to join tail with head to get circular linkedlist and then search for
    // len - k node (This solution will modify original list).

    public ListNode rotateRight(ListNode head, int k) {
      if (k < 0 || head == null || head.next == null) return head;
      int count = count(head);
      k = k % count;
      if ( k == 0) return head;
      int d = count - k;

      ListNode t = head;
      while ( --d > 0) {
        t = t.next;
      }

      ListNode temp = t.next;
      t.next = null;
      ListNode newHead = temp;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = head;
      return newHead;
    }

    private int count(ListNode l) {
      int count = 0;
      while (l != null) {
        l = l.next;
        count++;
      }
      return count;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    print(l1);
    print(sol.rotateRight(l1, 2));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }


}
