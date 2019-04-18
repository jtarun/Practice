package com.jtarun.practice.leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
 * is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodeInKGroup {
  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static class Solution {
    private static class Pair {
      ListNode tail;
      ListNode nxt;

      Pair(ListNode tail, ListNode nxt) {
        this.tail = tail;
        this.nxt = nxt;
      }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
      if ( head == null || head.next  == null || k <= 1) {
        return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode front = dummy, last;
      while (front.next != null) {
        last = front;
        for (int i = 0; i < k; i++) {
          last = last.next;
          if (last == null) {
            return dummy.next;
          }
        }

        ListNode nextFront = front.next;
        while (front.next != last) {
          ListNode temp = front.next;
          front.next = front.next.next;
          temp.next = last.next;
          last.next = temp;
        }
        front = nextFront;
      }

      return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
      if (head == null || head.next == null || k <= 1) {
        return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode it = head, t = dummy;

      Pair pair = getKList(it, k);
      while (pair.tail != null) {
        t.next = reverse(it);
        it.next = pair.nxt;
        t = it;
        it = pair.nxt;
        pair = getKList(it, k);
      }

      return dummy.next;
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

    private Pair getKList(ListNode head, int k) {
      Pair nullVal = new Pair(null, null);

      if (head == null) {
        return nullVal;
      }

      ListNode t = head, prev = null;
      while (k-- > 0 && t != null) {
        prev = t;
        t = t.next;
      }

      if (k != -1) {
        return nullVal;
      }

      prev.next = null;
      return new Pair(prev, t);
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
    //print(sol.reverseKGroup(l1, 2));
    print(sol.reverseKGroup(l1, 3));
  }

  private static void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " -> ");
      l = l.next;
    }
    System.out.println();
  }
}
