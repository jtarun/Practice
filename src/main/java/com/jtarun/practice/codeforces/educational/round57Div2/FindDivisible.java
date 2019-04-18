package com.jtarun.practice.codeforces.educational.round57Div2;

import java.util.*;
import java.io.*;

public class FindDivisible {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            out.print(l);
            out.print(" ");
            out.print(l*2);

            out.println();
        }
        out.close();

    }

}
