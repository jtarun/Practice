package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 448
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra
 * space.
 */
public class FindAllNumbersDisappearedInArray {

    private static class Solution {

        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer> res = new ArrayList<>();
            int n = nums.length;
            if (n == 0) return res;

            for (int i = 0; i < n; i++) {
                int ind = Math.abs(nums[i]);
                if (nums[ind-1] > 0) {
                    nums[ind-1] *= -1;
                }

            }

            for (int i = 0; i <n; i++) {
                if (nums[i] > 0) res.add(i+1);
            }

            return res;
        }

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();
            int n = nums.length;
            if (n == 0) return res;

            for (int i = 0; i < n; i++) {
                int ind = nums[i] % (n+1);
                nums[ind-1] += n+1;
            }

            for (int i = 0; i <n; i++) {
                if (nums[i] <= n) res.add(i+1);
            }

            return res;
        }
    }

}
