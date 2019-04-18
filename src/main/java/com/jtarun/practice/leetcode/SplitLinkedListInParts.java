package com.jtarun.practice.leetcode;

/** 725
 * Given a (singly) linked list with head node root, write a function to split the linked list into
 * k consecutive linked list "parts".
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1.
 * This may lead to some parts being null.
 *
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have
 * a size greater than or equal parts occurring later.
 *
 * Return a List of ListNode's representing the linked list parts that are formed.
 *
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 */
public class SplitLinkedListInParts {

    private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    private static class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            int n = count(root);

            ListNode[] res = new ListNode[k];
            ListNode t = root;
            int i = 0;
            int carry = n % k;
            int size = n/k;
            while (i < k) {
                int cnt = size + (carry > 0 ? 1 : 0);
                res[i] = t;

                ListNode prev = null;
                while (cnt-- > 0) {
                    prev = t;
                    t = t.next;
                }
                if (prev != null) prev.next = null;

                i++;
                carry--;
            }

            return res;
        }

        int count(ListNode head) {
            int cnt = 0;
            while (head != null) {
                cnt++;
                head = head.next;
            }
            return cnt;
        }
    }
}
