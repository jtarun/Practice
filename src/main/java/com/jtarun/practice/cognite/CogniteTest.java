package com.jtarun.practice.cognite;

public class CogniteTest {


    static int[] findMax(int[] a) {

        int n = a.length;
        int maxStart = 0, maxEnd = 0, curSum = 0, maxSum = curSum, end = 0, start = 0;

        int[] res = new int[3];

        while (end < n) {
            curSum += a[end];
            if (curSum < 0) {
                curSum = 0;
                start = end + 1;
            } else {
                if (maxSum < curSum) {
                    maxSum = curSum;
                    maxStart = start;
                    maxEnd = end;
                }
            }
            end++;
        }


        if (maxSum > 0) {

            res[0] = maxStart;
            res[1] = maxEnd + 1;
            res[2] = maxSum;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("hello");

        int[] a = {-5, 10, 3, 5, 7, -12};
        print(findMax(a));
        print(findMax(new int[]{-5}));
        print(findMax(new int[]{5}));
    }

    private static void print(int[] res) {
        System.out.println(res[0] + ":" + res[1] + "=" + res[2]);
    }

}
