package com.jtarun.practice.pramp;

/**
 * Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest
 * index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of
 * your solution and explain its correctness.
 */
public class ArrayIndexAndElementEquality {

    private int indexEqualsValueSearch(int[] arr) {
        int lo = 0, hi = arr.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;

            if (arr[mid] < mid) {
                lo = mid+1;
            } else {
                hi = mid;
            }

        }

        return arr[lo] == lo ? lo : -1;
    }

    public static void main(String[] args) {

    }


}
