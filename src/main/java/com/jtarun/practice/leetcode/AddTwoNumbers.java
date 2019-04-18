package com.jtarun.practice.leetcode;


/** 2
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode t = dummy;
      int sum = 0, carry = 0;
      while (l1 != null || l2 != null) {
        sum = carry;
        if (l1 != null) {
          sum += l1.val;
          l1 = l1.next;
        }

        if (l2 != null) {
          sum += l2.val;
          l2 = l2.next;
        }

        int d = sum % 10;
        carry = sum / 10;
        t.next = new ListNode(d);
        t = t.next;
      }

      if (carry != 0) {
        t.next = new ListNode(carry);
      }

      return dummy.next;
    }
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    ListNode d1 = new ListNode(2);
    ListNode d2 = new ListNode(4);
    ListNode d3 = new ListNode(3);
    d1.next = d2;
    d2.next = d3;

    ListNode e1 = new ListNode(5);
    ListNode e2 = new ListNode(6);
    ListNode e3 = new ListNode(4);
    e1.next = e2;
    e2.next = e3;


    ListNode res = sol.addTwoNumbers(d1, e1);

    print(d1);
    print(e1);
    print(res);

  }
}
