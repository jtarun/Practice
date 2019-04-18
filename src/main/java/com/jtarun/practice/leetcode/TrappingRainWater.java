package com.jtarun.practice.leetcode;

/** 42
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {

    private static class Solution {

        public int trap(int[] height) {
            if(height == null || height.length == 0) return 0;
            int leftMax = 0, rightMax = 0, waterTrapped = 0, left = 0, right = height.length-1;
            while(left < right) {
                leftMax = leftMax > height[left] ? leftMax : height[left];
                rightMax = rightMax > height[right] ? rightMax : height[right];
                waterTrapped += leftMax < rightMax ? leftMax - height[left++] : rightMax - height[right--];
            }
            return waterTrapped;
        }

        // O(1) space
        public int trap3(int[] height) {
            int n = height.length;
            if (n <= 2) return 0;
            int left = 0, right = n-1, maxLeft = 0, maxRight = 0, res = 0;
            while (left < right) {

                if (height[left] <= height[right]) {

                    if (height[left] < maxLeft) res += maxLeft - height[left];
                    else maxLeft = height[left];
                    left++;

                } else {
                    if (height[right] < maxRight) res += maxRight - height[right];
                    else maxRight = height[right];
                    right--;
                }

            }
            return res;
        }

        // O(n) space
        public int trap2(int[] height) {
            int n = height.length;
            if (n == 0) return 0;

            int[] left = new int[n];
            int[] right = new int[n];

            int maxLeft = height[0];
            for (int i = 1; i < n-1; i++) {
                left[i] = maxLeft;
                maxLeft = Math.max(height[i], maxLeft);
            }
            int maxRight = height[n-1];
            for (int i = n-2; i > 0; i--) {
                right[i] = maxRight;
                maxRight = Math.max(maxRight, height[i]);
            }

            int res = 0;
            for (int i = 1; i < n-1; i++) {
                if (height[i] < left[i] && height[i] < right[i]) res += Math.min(left[i],right[i]) - height[i];
            }

            return res;
        }
    }

}
