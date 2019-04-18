package com.jtarun.practice.interviewbit.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution1 {
  public int largestRectangleArea(ArrayList<Integer> a) {

    Stack<Integer> s = new Stack<>();
    int i = 0, maxArea = 0;
    while (i < a.size()) {

      int e = a.get(i);
      if (s.empty() || e >= a.get(s.peek())) {
        s.push(i++);
      } else {
        int tp = s.pop();

        int area = a.get(tp) * (s.empty() ? i : i - s.peek() - 1);

        maxArea = Math.max(maxArea, area);
      }

    }

    while (!s.empty()) {
      int tp = s.pop();

      int area = a.get(tp) * (s.empty() ? i : i - s.peek() - 1);

      maxArea = Math.max(maxArea, area);
    }
    return maxArea;

  }

}




public class MaxAreaHistogram {

  public static void main(String[] args) {
    Solution1 sol = new Solution1();
    List<Integer> testcase1 = Arrays.asList(90, 58, 69, 70, 82, 100, 13, 57, 47, 18);

    ArrayList<Integer> arr = new ArrayList<>();
    arr.addAll(testcase1);
    int area = sol.largestRectangleArea(arr);
    System.out.println(area);
  }


}
