package com.jtarun.practice.leetcode;

/** 109
 * Given a singly linked list where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 */
public class SortedListToBST {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class Solution {

    public TreeNode sortedListToBST(ListNode head) {
      if (head == null) {
        return null;
      }
      if (head.next == null) {
        return new TreeNode(head.val);
      }

      ListNode mid = findMid(head);
      ListNode second = mid.next, t = head, prev = null;
      mid.next = null;
      while (t != mid) {
        prev = t;
        t = t.next;
      }

      TreeNode root = new TreeNode(mid.val);
      if (prev != null) {
        prev.next = null;
        root.left = sortedListToBST(head);
      }

      root.right = sortedListToBST(second);
      return root;
    }

    private ListNode findMid(ListNode head) {
      ListNode slow = head, fast = head.next;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      return slow;
    }
  }
}
