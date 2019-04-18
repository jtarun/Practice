package com.jtarun.practice.leetcode;

/* 138
 * A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyLinkedListRandomPointer {
  private static class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }
  }

  private static class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null) {
        return null;
      }

      RandomListNode t = head;
      while (t != null) {
        RandomListNode n = new RandomListNode(t.label);
        RandomListNode temp = t.next;
        t.next = n;
        n.next = temp;
        t = temp;
      }

      t = head;
      while (t != null) {
        if (t.random != null) {
          t.next.random = t.random.next;
        }
        t = t.next.next;
      }

      RandomListNode dummy = new RandomListNode(0), t2 = dummy;
      t = head;
      while (t != null) {
        t2.next = t.next;
        t2 = t.next;
        t.next = t2.next;
        t = t.next;
        t2.next = null;
      }

      return dummy.next;
    }
  }

}
