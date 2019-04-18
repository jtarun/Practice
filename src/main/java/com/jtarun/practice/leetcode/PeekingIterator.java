package com.jtarun.practice.leetcode;

import java.util.Iterator;

/** 284
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator
 * that support the peek() operation -- it essentially peek() at the element that will be returned by the
 * next call to next().
 */
public class PeekingIterator {

    private static class PeekingIteratorImpl implements Iterator<Integer> {

        Iterator<Integer> iterator;
        Integer next = null;

        public PeekingIteratorImpl(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (iterator.hasNext()) this.next = iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return this.next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int ret = next;
            if (iterator.hasNext()) this.next = iterator.next();
            else this.next = null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return this.next != null;
        }
    }

}
