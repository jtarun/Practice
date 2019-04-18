package com.jtarun.practice.leetcode;

import java.util.*;

/** 406
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers
 * (h, k), where h is the height of the person and k is the number of people in front of this person who have a
 * height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 */
public class QueueReconstructionByHeight {

    private static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (p1, p2) -> p2[0]-p1[0] != 0 ? p2[0]-p1[0] : p1[1]-p2[1]);

            List<int[]> p = new ArrayList<>();
            for (int[] person: people) {
                p.add(person[1], person);
            }

            for (int i = 0; i < people.length; i++) {
                people[i] = p.get(i);
            }
            return people;
        }

        private static class Node {
            int[] val;
            Node next;
            Node(int[] val) {
                this.val = val;
                next = null;
            }
        }

        public int[][] reconstructQueue2(int[][] people) {
            if (people.length <= 1) return people;

            Arrays.sort(people, (p1, p2) -> p2[0]-p1[0] != 0 ? p2[0]-p1[0] : p1[1]-p2[1]);

            Node dummy = new Node(new int[]{0,0});
            Node t = dummy;
            for (int[] person : people) {
                t.next = new Node(person);
                t = t.next;
            }

            t = dummy.next.next;
            Node pret = dummy.next;
            while (t != null) {
                Node prex = dummy;
                Node x = dummy.next;
                int greater = t.val[1];

                while (greater > 0) {
                    prex = x;
                    x = x.next;
                    greater--;
                }

                if (x != t) {
                    Node n = new Node(new int[]{t.val[0], t.val[1]});
                    prex.next = n;
                    n.next = x;

                    // delete t
                    pret.next = t.next;
                    t = pret.next;
                } else {
                    pret = t;
                    t = t.next;
                }
            }

            t = dummy.next;
            int i = 0;
            int[][] res = new int[people.length][2];
            while (t != null) {
                res[i][0] = t.val[0];
                res[i][1] = t.val[1];
                i++;
                t = t.next;
            }

            return res;
        }
    }

    private static void print(int[][] res) {
        for (int[] person : res) {
            System.out.print("{" + person[0] + "," + person[1] + "}, ");
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = sol.reconstructQueue(people);
        print(res);
    }
}
