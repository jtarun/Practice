package com.jtarun.practice.interviewbit.linkedlist;


class Solution2 {
  public ListNode insertionSortList(ListNode a) {

    if (a == null || a.next == null) return a;
    ListNode dummy = new ListNode(0);
    dummy.next = a;
    ListNode cur = a.next;
    while (cur != null) {
      ListNode nxt = cur.next;
      insertSorted(dummy, cur, nxt);
      cur = nxt;
    }
    return dummy.next;
  }


  private void insertSorted(ListNode dummy , ListNode b, ListNode nxt) {
    ListNode prev = dummy, cur = dummy.next;
    while (b.val > cur.val && cur != b) {
      prev = cur;
      cur = cur.next;
    }

    if (cur != b) {
      b.next = prev.next;
      prev.next = b;
    }

    while (cur != null && cur.next != b) {
      cur = cur.next;
    }
    if (cur != null)
    cur.next = nxt;
  }
}


public class InsertionSort {

  public static void main(String[] args) {
    Solution2 solution = new Solution2();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(10);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(6);

    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;


    ListNode l = solution.insertionSortList(l1);
    while (l != null) {
      System.out.print(l.val + " ");
      l = l.next;
    }
  }

}
