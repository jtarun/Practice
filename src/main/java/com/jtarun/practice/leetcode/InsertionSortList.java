package com.jtarun.practice.leetcode;

/** 147
 * Sort a linked list using insertion sort.
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs
 * within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 */
public class InsertionSortList {

    private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    private static class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(Integer.MIN_VALUE), t = head, prevt = dummy;

            while (t != null) {
                ListNode nxt = t.next;
                insert(dummy, t);
                t = nxt;
            }

            return dummy.next;
        }

        private void insert(ListNode head, ListNode t) {
            t.next = null;
            ListNode s = head.next, prev = head;

            while (s != null && s.val <= t.val) {
                prev = s;
                s = s.next;
            }

            t.next = s;
            prev.next = t;
        }
    }

}
