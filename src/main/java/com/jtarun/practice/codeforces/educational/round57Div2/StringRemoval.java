package com.jtarun.practice.codeforces.educational.round57Div2;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class StringRemoval {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int mod = 998244353;

        int n = sc.nextInt();
        String s = sc.next();

        int i = 0, j = n-1;

        while (i+1 < n && s.charAt(i) == s.charAt(i+1)) i++;
        while (j-1 >= 0 && s.charAt(j) == s.charAt(j-1)) j--;


        int l = i+1, r = n-j;

        char c = s.charAt(i);
        char d = s.charAt(j);
        if (c == d) {
            long res = ((long)(l+1) * (long)(r+1)) % mod;
            out.println(res);
        } else {
            out.println(l + r + 1);
        }

        out.close();

    }

}
