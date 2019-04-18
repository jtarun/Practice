package com.jtarun.practice.leetcode;

import java.util.*;

/** 382
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same
 * probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently
 * without using extra space?
 */
public class LinkedListRandomNode {

     private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    private static class Solution {
        Random random = new Random();
        int count = 0;
        ListNode head;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            ListNode t = head;
            while (t != null) {
                count++;
                t = t.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int x = random.nextInt(count);

            ListNode t = head;
            while (x-- > 0) {
                t = t.next;
            }

            return t.val;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

}
