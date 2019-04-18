package com.jtarun.practice.leetcode;

import java.util.*;

/** 341
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 */
public class FlattenNestedListIterator {

    private interface NestedInteger {

         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();

         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
     }

    private static class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> s;

        public NestedIterator(List<NestedInteger> nestedList) {
            s = new Stack<>();
            addToStack(nestedList);
        }

        @Override
        public Integer next() {
            return s.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            if (s.isEmpty()) return false;
            if (s.peek().isInteger()) return true;

            addToStack(s.pop().getList());
            return hasNext();
        }

        private void addToStack(List<NestedInteger> list) {
            for (int i = list.size()-1; i >= 0; i--) {
                s.add(list.get(i));
            }
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
