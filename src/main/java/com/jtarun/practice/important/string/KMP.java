package com.jtarun.practice.important.string;

public class KMP {

    private static boolean match(String str, String pat) {
        if (pat.length() == 0) return true;
        int[] lcp = lcp(pat);

        int i = 0, j = 0;
        while (i < str.length()) {

            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == pat.length()) {
                    System.out.println("pattern found at index : " + (i - j));
                    j = lcp[j-1];
                }
            } else if (j == 0) {
                i++;
            } else {
                j = j - 1 > 0 ? lcp[j - 1] : 0;
            }
        }

        return false;
    }

    private static int[] lcp(String s) {
        int[] lcp = new int[s.length()];
        int i = 0, j = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                lcp[j++] = i;
            } else {
                if (i == 0) {
                    lcp[j++] = 0;
                } else {
                    i = lcp[i - 1];
                }
            }

        }
        return lcp;
    }

    public static void main(String[] args) {
        match("abc hellolhelloworldhello", "lhello");
    }

}
