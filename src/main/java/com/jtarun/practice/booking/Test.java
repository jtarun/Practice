package com.jtarun.practice.booking;

import java.util.*;

public class Test {

    // 1
    static int triangle(int a, int b, int c) {
        int res = 0;
        long sum1 = a + b;
        long sum2 = b + c;
        long sum3 = c + a;

        if (sum1 > c && sum2 > a && sum3 > b) {
            res = 1;
        }

        if (res == 0) return res;
        res = 2;
        if (a == b && b == c) res = 1;
        return res;
    }

    // 2
    static int[] delta_encode(int[] array) {
        if (array.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        res.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            long diff = (long)array[i] - (long)array[i-1];
            if (diff < -127 || diff > 127) {
                res.add(-128);
            }
            res.add((int)diff);
        }
        int[] ans = new int[res.size()];
        int i = 0;
        while (i < res.size()) {
            ans[i] = res.get(i);
            i++;
        }
        return ans;
    }


    // 3

    static class Pair {
        int time;
        int val;
        Pair(int time, int val) {
            this.time = time;
            this.val = val;
        }
    }

    static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
        int n = callsTimes.size();
        if (n == 0) return 0;

        List<Pair> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> cur = callsTimes.get(i);
            int curStart = cur.get(0);
            int curEnd = cur.get(1);

            a.addAll(Arrays.asList(new Pair(curStart, 1), new Pair(curEnd, -1)));

        }


        Collections.sort(a, (p1, p2) -> {
            int c = Integer.compare(p1.time, p2.time);
            if (c == 0) {
                if (p1.val == p2.val) return -1;
                if (p1.val == 1) {
                    c = -1;
                } else c = 1;
            }
            return c;
        });

        int maxNeeded = 1;
        int diff = 0;
        for (int i = 0; i < a.size(); i++) {
            int v = a.get(i).val;
            diff += v;
            if (diff > maxNeeded) {
                maxNeeded = diff;
            }
        }


        if (maxNeeded <= noOfCurrentAgents) return 0;
        return maxNeeded - noOfCurrentAgents;
    }



    // 4
    static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {

        String[] parts = keywords.split(" ");
        Set<String> keys = new HashSet<>();
        for (String part: parts) {
            keys.add(part.toLowerCase());
        }

        Map<Integer, Integer> h = new HashMap<>();
        int n = hotel_ids.size();
        for (int i = 0; i < n; i++) {
            String review = reviews.get(i);
            int hotelId = hotel_ids.get(i);

            int cnt = count(review, keys);
            h.put(hotelId, h.getOrDefault(hotelId, 0) + cnt);
        }

        List<int[]> res = new ArrayList<>();
        for (int hotelId : h.keySet()) {
            int cnt = h.get(hotelId);

            res.add(new int[]{hotelId, cnt});
        }

        Collections.sort(res, (a, b) -> {
            int c = Integer.compare(b[1], a[1]);
            if (c == 0) c = Integer.compare(a[0], b[0]);
            return c;
        });

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            ans.add(res.get(i)[0]);
        }

        return ans;
    }

    private static int count(String review, Set<String> keys) {
        int count = 0;

        int i = 0;
        int n = review.length();
        while (i < n) {
            char c = review.charAt(i);
            if (!character(c)) {
                i++;
                continue;
            } else {
                int j = i+1;
                StringBuilder sub = new StringBuilder();
                sub.append(lower(c));
                while (j < n && character(review.charAt(j))) {
                    sub.append(lower(review.charAt(j)));
                    j++;
                }

                if (keys.contains(sub.toString())) count++;
                i = j;
            }
        }
        return count;
    }

    private static char lower(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c + 32);
        return c;
    }

    private static boolean character (char c) {
        if ((c >= 'A' && c <= 'Z') ||
         (c >= 'a' && c <= 'z')) return true;

        return false;
    }




    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1481122000, 1481122020);
        List<Integer> l2 = Arrays.asList(1481122000, 1481122040);
        List<Integer> l3 = Arrays.asList(1481122030, 1481122035);

        List<List<Integer>> l = Arrays.asList(l1, l2, l3);

        int ans = howManyAgentsToAdd(1, l);
        System.out.println(ans);
    }

}
