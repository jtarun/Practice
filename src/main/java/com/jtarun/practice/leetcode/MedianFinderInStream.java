package com.jtarun.practice.leetcode;

import java.util.*;

/** 295
 * Median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class MedianFinderInStream {

    private static class MedianFinder {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<Integer>((a,b) -> a==b ? -1: b-a);
            minHeap = new PriorityQueue<Integer>((a,b) -> a==b ? -1: a-b);
        }

        public void addNum(int num) {
            if (maxHeap.size() == 0) {
                maxHeap.add(num);
                return;
            }

            int leftCount = maxHeap.size();
            int rightCount = minHeap.size();

            double median = findMedian();

            if (num < median) {
                if (leftCount > rightCount) {
                    minHeap.add(maxHeap.poll());
                }
                maxHeap.add(num);
            } else {
                if (rightCount > leftCount) {
                    maxHeap.add(minHeap.poll());
                }
                minHeap.add(num);
            }
        }

        public double findMedian() {
            int leftCount = maxHeap.size();
            int rightCount  = minHeap.size();
            if(leftCount > rightCount) {
                return maxHeap.peek();
            } else if (rightCount > leftCount) {
                return minHeap.peek();
            }
            return ((double)maxHeap.peek() + minHeap.peek())/2;
        }
    }


    private static class MedianFinder2 {

        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        int size;

        /** initialize your data structure here. */
        public MedianFinder2() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>(1, (a, b) -> b - a);
            size = 0;
        }

        public void addNum(int num) {
            ++size;
            if(max.size() != 0 && num < max.peek())
                max.add(num);
            else min.add(num);
        }

        public double findMedian() {
            while(max.size() > min.size() + (size % 2))
                min.add(max.poll());

            while(max.size() < min.size() + (size % 2))
                max.add(min.poll());

            if(size % 2 == 0)
                return (min.peek() + max.peek()) / 2.0;
            else return max.peek();
        }
    }



}
