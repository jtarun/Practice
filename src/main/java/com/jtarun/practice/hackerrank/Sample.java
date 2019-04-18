package com.jtarun.practice.hackerrank;

import java.util.*;
import java.io.*;

import static java.util.stream.Collectors.joining;

public class Sample {

    static List<Integer> oddNumbers(int l, int r) {
        if (l % 2 == 0) l++;
        List<Integer> res = new ArrayList<>();
        while (l <= r) {
            res.add(l);
            l += 2;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> res = oddNumbers(l, r);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
