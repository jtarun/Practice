package com.jtarun.practice.leetcode;

/** 860
 * At a lemonade stand, each lemonade costs $5.
 *
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 *
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
 * You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 *
 * Note that you don't have any change in hand at first.
 *
 * Return true if and only if you can provide every customer with correct change.
 */
public class LemonadeChange {

    private static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int n = bills.length;
            if (n == 0) return true;
            int[] count = new int[3];

            for (int i = 0; i < n; i++) {
                int x = bills[i];

                while (x > 20 && count[2] > 0) {
                    count[2]--;
                    x -= 20;
                }

                while (x > 10 && count[1] > 0) {
                    count[1]--;
                    x -= 10;
                }

                while (x > 5 && count[0] > 0) {
                    count[0]--;
                    x -= 5;
                }

                if (x != 5) return false;

                count[bills[i]/10]++;
            }

            return true;
        }
    }

}
