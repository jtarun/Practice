package com.jtarun.practice.interviewbit.trees;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution2 {
  class Pair {
    Integer first;
    Integer second;

    Pair(Integer x, Integer y) {
      this.first = x;
      this.second = y;
    }
  }

  public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {


    Map<Integer, TreeSet<Pair>> h = new TreeMap<>();
    verticalOrderRec(A, h, 0, 0);
    ArrayList<ArrayList<Integer>> out = new ArrayList<>();
    h.values().forEach(set -> {
      ArrayList<Integer> t = new ArrayList<>();
      for (Pair pair : set) {
        t.add(pair.first);
      }
      out.add(t);
    });

    return out;
  }


  private void verticalOrderRec(TreeNode a, Map<Integer, TreeSet<Pair>> h,
                                int width, int level) {

    if (a == null) {
      return;
    }

    Comparator<Pair> comparator = (p1, p2) -> {
      int cmp = Integer.compare(p1.second, p2.second);
      if (cmp == 0) {
        cmp = 1;
      }
      return cmp;
    };

    h.computeIfAbsent(width, k -> new TreeSet<>(comparator)).add(new Pair(a.val, level));
    verticalOrderRec(a.left, h, width - 1, level + 1);
    verticalOrderRec(a.right, h, width + 1, level + 1);

  }
}


public class Vertical {

  public static void main(String[] args) {
    Solution2 sol = new Solution2();

    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    TreeNode n8 = new TreeNode(8);
    TreeNode n9 = new TreeNode(9);
    TreeNode n10 = new TreeNode(10);
    TreeNode n11 = new TreeNode(11);
    TreeNode n12 = new TreeNode(12);
    TreeNode n13 = new TreeNode(13);
    TreeNode n14 = new TreeNode(14);
    TreeNode n15 = new TreeNode(15);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    n4.left = n8;
    n4.right = n9;
    n5.left = n10;
    n5.right = n11;
    n6.left = n12;
    n6.right = n13;
    n7.left = n14;
    n7.right = n15;

    sol.verticalOrderTraversal(n1).forEach(list -> {
      list.forEach(e -> System.out.print(e + " "));
      System.out.println();
    });
  }

}
