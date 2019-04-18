package com.jtarun.practice.codeforces.educational.round57Div2;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EasyProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        String s = sc.next();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        List[] h = new List[256];
        Arrays.fill(h, new ArrayList<Integer>());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            h[c].add(i);
        }

        int res = 0;
        boolean done = false;
        int i = h['h'].isEmpty()? -1 : (int)h['h'].get(0);
        int j = h['a'].isEmpty()? -1 : (int)h['a'].get(0);
        int k = h['r'].isEmpty()? -1 : (int)h['r'].get(0);
        int l = h['d'].isEmpty()? -1 : (int)h['d'].get(0);
        if (i == -1 || j == -1 || k == -1 || l == -1) done = true;
        while (!done) {
            // clean
            if (i == h['h'].size() || j == h['a'].size()  || k == h['r'].size() || l == h['d'].size()) {
                break;
            }

            if ((int)h['h'].get(i) > (int)h['a'].get(j)) {
                j++;
            } else if ((int)h['h'].get(i) > (int)h['a'].get(j)) {
                k++;
            }

        }


        out.print(res);
        out.close();
    }

}
