package com.jtarun.practice.leetcode;

import java.util.*;

/** 658
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should
 * also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 *
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 */
public class FindKClosestElements {

    private static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int ind = Arrays.binarySearch(arr, 0, arr.length-1, x);
            if (ind < 0) ind = -ind-1;

            int i = ind, n = arr.length;
            if (arr[i] != x) i--;
            int j = i+1;

            List<Integer> res = new ArrayList<>();
            Deque<Integer> q = new LinkedList<>();
            while ((i >= 0 || j < n) && k-- > 0) {
                int diff1 = i >= 0 ? x - arr[i] : Integer.MAX_VALUE;
                int diff2 = j < n  ? arr[j] - x : Integer.MAX_VALUE;

                if (i >= 0 && diff1 <= diff2) {
                    q.addFirst(arr[i]);
                    i--;
                } else {
                    q.addLast(arr[j]);
                    j++;
                }
            }
            res.addAll(q);

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;
        sol.findClosestElements(arr, k, x).forEach(l -> System.out.print(l + " "));
    }

}
