package com.jtarun.practice.leetcode;

import java.util.*;

/** 721
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a
 * name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some
 * email that is common to both accounts. Note that even if two accounts have the same name, they may belong to
 * different people as people could have the same name. A person can have any number of accounts initially,
 * but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the
 * name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 */
public class AccountsMerge {

    private static class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, List<Integer>> h = new HashMap<>();
            for (int i = 0; i < accounts.size(); i++) {
                List<String> emails = accounts.get(i);
                for (int j = 1; j < emails.size(); j++) {
                    h.computeIfAbsent(emails.get(j), k -> new ArrayList<>()).add(i);
                }
            }

            UnionFind uf = new UnionFind(accounts.size());
            for (List<Integer> acns : h.values()) {
                for (int i = 1; i < acns.size(); i++) {
                    uf.union(acns.get(i-1), acns.get(i));
                }
            }

            Map<Integer, List<Integer>> accountSets = new HashMap<>();
            int[] parents = uf.getParents();
            for (int i = 0; i < accounts.size(); i++) {
                accountSets.computeIfAbsent(uf.find(i), k -> new ArrayList<>()).add(i);
            }

            Map<Integer, Set<String>> merged = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : accountSets.entrySet()) {
                int rootAcc = entry.getKey();
                List<Integer> acnts = entry.getValue();
                Set<String> emailSet = new HashSet<>();
                for (int acc : acnts) {
                    List<String> emails = accounts.get(acc);
                    for (int j = 1; j < emails.size(); j++) {
                        emailSet.add(emails.get(j));
                    }
                }
                merged.put(rootAcc, emailSet);
            }

            List<List<String>> res = new ArrayList<>();
            for (Map.Entry<Integer, Set<String>> entry : merged.entrySet()) {
                int rootAcc = entry.getKey();
                String name = accounts.get(rootAcc).get(0);
                List<String> val = new ArrayList<>();
                val.add(name);
                val.addAll(entry.getValue());
                res.add(val);
            }

            for (List<String> emails : res) {
                Collections.sort(emails);
            }

            return res;
        }

        private class UnionFind {
            int[] parents;
            UnionFind(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) parents[i] = i;
            }

            int[] getParents() {
                return parents;
            }

            void union(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (x != y) {
                    parents[x] = y;
                }
            }

            int find(int i) {
                List<Integer> path = new ArrayList<>();
                while (i != parents[i]) {
                    path.add(i);
                    i = parents[i];
                }

                for (int node : path) {
                    parents[node] = i;
                }

                return i;
            }
        }
    }

}
