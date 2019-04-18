package com.jtarun.practice.interviewbit.linkedlist;


//Definition for singly-linked list.
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class Solution {
  public ListNode swapPairs(ListNode a) {
    if (a == null || a.next == null) return a;

    ListNode prev = a, cur = a.next, head = cur, lastPrev = null;

    while (prev != null && cur != null) {
      if (lastPrev != null) {
        lastPrev.next =  cur;
      }

      lastPrev = prev;

      ListNode t = cur.next;
      cur.next = prev;
      prev = t;
      if (prev != null)
        cur = prev.next;
    }
    if (lastPrev != null)
      lastPrev.next = prev;

    return head;
  }
}



public class SwapPairs {
  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(6);

    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;


    ListNode l = solution.swapPairs(l1);
    while (l != null) {
      System.out.println(l.val);
      l = l.next;
    }
  }



}
