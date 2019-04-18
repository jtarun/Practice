package com.jtarun.practice.leetcode;

import java.util.*;

/** 599
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite
 * restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie
 * between answers, output all of them with no order requirement. You could assume there always exists an answer.
 *
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 */
public class MinimumIndexSumOfTwoLists {

    private static class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> h = new HashMap<>();
            for (int i = 0; i< list1.length; i++) {
                h.put(list1[i], i);
            }

            int min = list1.length + list2.length, cnt = 0;
            List<String> res = new ArrayList<>();
            for (int i = 0; i < list2.length; i++) {
                if (h.containsKey(list2[i])) {
                    int rank = i + h.get(list2[i]);

                    if (rank == min) {
                        res.add(list2[i]);
                    } else if (rank < min){
                        min = rank;
                        res.clear();
                        res.add(list2[i]);
                    }
                }
            }

            String[] ans = new String[res.size()];
            int i = 0;
            for (String name : res) ans[i++] = name;

            return ans;
        }
    }

}
