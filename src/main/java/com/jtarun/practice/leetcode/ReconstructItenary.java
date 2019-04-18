package com.jtarun.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItenary {

    private static class Solution {
        public List<String> findItinerary(String[][] tickets) {
            Map<String, String> h = new HashMap<>();

            for (String[] ticket : tickets) {
                String min = ticket[1];
                String to = h.get(ticket[0]);
                if (to != null && to.compareTo(min) < 1) {
                    min = to;
                }
                h.put(ticket[0], min);
            }

            List<String> res = new ArrayList<>();
            String s = "JFK";
            if (h.get(s) == null) return res;
            do {
                res.add(s);
                s = h.get(s);
            } while (s != null);

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] tickets = {
                {"JFK","SFO"}
        };
        sol.findItinerary(tickets).forEach(x -> System.out.print(x + " "));
    }
}
