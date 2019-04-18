package com.jtarun.practice.leetcode;

/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only
 * access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * 4 -> 5 -> 1 -> 9
 */
public class DeleteGivenNodeLinkedList {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    public void deleteNode(ListNode node) {
      ListNode prev = node, cur = node.next;
      while (cur.next != null) {
        prev.val = cur.val;
        prev = cur;
        cur = cur.next;
      }
      prev.val = cur.val;
      prev.next = null;
    }
  }
}
