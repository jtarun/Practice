package com.jtarun.practice.leetcode;

/** 430
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure,
 * as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the
 * first level of the list.
 */
public class FlattenLinkedList {

    // Definition for a Node.
    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    private static class Solution {
        public Node flatten(Node head) {
            if (head == null) return null;

            if (head.child != null) {
                Node child = flatten(head.child);
                Node temp = head.next;

                Node last = child;
                while (last.next != null) {
                    last = last.next;
                }

                if (temp != null) temp.prev = last;

                head.next = child;
                child.prev = head;

                head.child = null;

                last.next = flatten(temp);
            } else {
                head.next = flatten(head.next);
            }

            return head;
        }
    }

}
