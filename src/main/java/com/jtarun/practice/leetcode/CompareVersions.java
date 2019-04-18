package com.jtarun.practice.leetcode;

/** 165
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Example 1:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 *
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 */
public class CompareVersions {

    private static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] part1 = version1.split("\\.");
            String[] part2 = version2.split("\\.");
            int m = part1.length;
            int n = part2.length;
            while (m > 0 && Integer.parseInt(part1[m-1]) == 0) m--;
            while (n > 0 && Integer.parseInt(part2[n-1]) == 0) n--;

            for (int i = 0; i < Math.min(m, n); i++) {
                int n1 = Integer.parseInt(part1[i]);
                int n2 = Integer.parseInt(part2[i]);
                if (n1 < n2) return -1;
                else if (n2 < n1) return 1;
            }

            return Integer.compare(m, n);
        }
    }

}
