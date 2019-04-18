package com.jtarun.practice.leetcode;

/**
 * 24
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodeInPairs {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class Solution {

        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;

            ListNode dummy = new ListNode(0);

            dummy.next = head;
            ListNode cur = head, prev = dummy;

            while (cur != null && cur.next != null) {

                prev.next = cur.next;
                ListNode nxt = cur.next.next;
                cur.next.next = cur;
                cur.next = nxt;
                prev = cur;
                cur = nxt;

            }

            return dummy.next;
        }


        public ListNode swapPairsRec(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode first = head;
            ListNode second = head.next;
            ListNode third = head.next.next;

            second.next = first;
            first.next = swapPairsRec(third);

            return second;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        Solution sol = new Solution();
        print(l1);
        print(sol.swapPairs(l1));
    }

    private static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " -> ");
            l = l.next;
        }
        System.out.println();
    }

}
