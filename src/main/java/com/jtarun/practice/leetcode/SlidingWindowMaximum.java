package com.jtarun.practice.leetcode;

import java.util.*;

/** 239
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array
 * to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position. Return the max sliding window.
 */
public class SlidingWindowMaximum {

    private static class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) return new int[]{};
            int n = nums.length;
            int[] res = new int[n-k+1];
            int ri = 0;
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while(!q.isEmpty() && q.peek() <= i - k) q.poll();

                while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
                q.offer(i);
                if (i >= k-1) {
                    res[ri++] = nums[q.peek()];
                }
            }
            return res;
        }

        public int[] maxSlidingWindow2(int[] nums, int k) {
            if (nums.length == 0) return new int[]{};
            TreeSet<Integer> t = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b);
            int[] res = new int[nums.length - k + 1];
            int x = 0;
            for (int i = 0; i < nums.length; i++) {
                t.add(i);
                if (i >= k - 1) {
                    res[x++] = nums[t.last()];
                    t.remove(i - k + 1);
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] ans = sol.maxSlidingWindow(new int[]{1,-1}, 1);
        int[] ans = sol.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }

}
