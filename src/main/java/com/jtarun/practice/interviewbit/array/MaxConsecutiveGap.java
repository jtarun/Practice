package com.jtarun.practice.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution6 {

  // DO NOT MODIFY THE LIST
  public int maximumGap(final List<Integer> a) {
    int n = a.size();
    if (n < 2) return 0;

    int max = a.get(0), min =a.get(0);

    for (int i = 1; i < n; i++) {
      max = Math.max(a.get(i), max);
      min = Math.min(a.get(i), min);
    }

    ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < n-1; i++) buckets.add(new ArrayList<>());
    int size = (max - min + n -1)/(n-1);
    for (int i = 0; i < n; i++) {
      int x = a.get(i);
      if (x != max && x != min) {
        int k = (x - min)/size;
        if (k == 97) {
          System.out.println(k);
        }
        buckets.get(k).add(x);
      }
    }

    ArrayList<ArrayList<Integer>> bucketsRange = new ArrayList<>();
    bucketsRange.add(new ArrayList<>(Arrays.asList(min, min)));

    for (int i = 0; i < n-1; i++) {
      ArrayList<Integer> bucket = buckets.get(i);
      if (bucket.size() == 0) continue;
      int bucketmax = bucket.get(0), bucketmin = bucket.get(0);
      for (int j = 1; j < bucket.size(); j++) {
        bucketmax = Math.max(bucketmax, bucket.get(j));
        bucketmin = Math.min(bucketmin, bucket.get(j));
      }
      bucketsRange.add(new ArrayList<>(Arrays.asList(bucketmin, bucketmax)));
    }

    bucketsRange.add(new ArrayList<>(Arrays.asList(max, max)));
    int res = 0;
    for (int i = 1; i < bucketsRange.size(); i++) {
      int d = bucketsRange.get(i).get(0) - bucketsRange.get(i-1).get(1);
      res = Math.max(res, d);
    }

    return res;
  }

  public int maximumGap2(final List<Integer> a) {
    int n = a.size();
    if (n < 2) return 0;

    ArrayList<Integer> sorted = new ArrayList<>(a);
    Collections.sort(sorted);
    int res = Integer.MIN_VALUE;
    for (int i = 1; i < sorted.size(); i++) {
      res = Math.max(res, sorted.get(i) - sorted.get(i-1));
    }
    return res;
  }
}



public class MaxConsecutiveGap {
  public static void main(String[] args) {
    Solution6 sol = new Solution6();
    int res = sol.maximumGap(Arrays.asList(12115,10639,2351,29639,31300,11245,16323,24899,8043,
        4076,17583,15872,19443,12887,5286,6836,31052,25648,17584,24599,13787,24727,12414,5098,26096,
        23020,25338,28472,4345,25144,27939,10716,3830,13001,7960,8003,10797,5917,22386,12403,2335,
        32514,23767,1868,29882,31738,30157,7950,20176,11748,13003,13852,19656,25305,7830,3328,19092,
        28245,18635,5806,18915,31639,24247,32269,29079,24394,18031,9395,8569,11364,28701,32496,28203,
        4175,20889,28943,6495,14919,16441,4568,23111, 20995,7401,30298,2636,16791,1662,27367,2563,
        22169,1607,15711,29277,32386,27365,31922,26142,8792));
    System.out.println(res);
  }


}
