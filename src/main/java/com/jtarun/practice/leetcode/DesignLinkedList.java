package com.jtarun.practice.leetcode;

public class DesignLinkedList {
  class Node {
    int val;
    Node next;
    Node prev;
    Node(int val) {
      this.val = val;
    }
  }

  class MyLinkedList {
    Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
      if (index < 0) return  -1;
      Node t = head;
      while (--index >= 0 && t != null) {
        t = t.next;
      }

      if (t == null) return -1;
      return t.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
      Node n = new Node(val);
      n.next = head;
      if (head != null) {
        head.prev = n;
      }
      head = n;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
      Node n = new Node(val), t = head;
      if ( head == null) {
        head = n;
        return;
      }
      while (t.next != null) {
        t = t.next;
      }

      n.prev = t;
      t.next = n;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
      if (index == 0) {
        addAtHead(val);
        return;
      }
      Node t = head, n = new Node(val);
      while (t != null && --index > 0) {
        t = t.next;
      }
      if (t != null) {
        n.prev = t;
        Node temp = t.next;
        t.next = n;
        n.prev = t;
        n.next = temp;
        if (temp != null) {
          temp.prev = n;
        }
      }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
      if (index < 0) return;
      if (index == 0) {
        if (head != null) {
          head = head.next;
        }
        return;
      }

      Node t = head, prev = null;
      while (index-- > 0 && t != null) {
        prev = t;
        t = t.next;
      }

      if (t == null) {
        return;
      }

      prev.next = t.next;
      if (prev.next != null)
        prev.next.prev = prev;
    }
  }
}
