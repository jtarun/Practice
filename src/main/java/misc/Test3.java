package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    private static class Node {
        int val;
        Node next;
    }

    static Node nthFromLast(Node head, int n) {
        Node second = head, first = head;

        while (second != null && n-- > 0) {
            second = second.next;
        }

        if (second == null) return null;

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    static List<int[]> findPairsToSum(int[] a, int k) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(a);
        int n = a.length, i = 0, j = n-1;
        while (i < j) {
            int sum = a[i] + a[j];
            if (sum == k) {

                int l = i+1, r = j-1, cnt;
                int leftVal, rightVal;
                while(l <= j && a[l] == a[l-1]) l++;

                if (l == j+1) {
                    int x = j - i + 1;
                    cnt = (x * (x-1)) / 2;

                    leftVal = a[i];
                    rightVal = a[j];

                    i = j+1;
                } else {
                    while (r >= i && a[r] == a[r + 1]) r--;
                    int cntLeft = l - i;
                    int cntRight = j - r;
                    cnt = cntLeft * cntRight;
                    leftVal = a[i];
                    rightVal = a[j];

                    i = l;
                    j = r;
                }

                if (cnt > 0) {
                    int[] pair = {leftVal, rightVal};
                    add(res, pair, cnt);
                }

            } else if (sum > k)j--;
            else i++;
        }

        return res;
    }

    private static void add(List<int[]> res, int[] pair, int cnt) {
        for (int i = 0; i < cnt; i++) {
            res.add(pair);
        }
    }

    public static void main(String[] args) {
        int[] arr ={2, 6, 3, 9, 7, 11};

        int[] arr2 ={2, 4 ,4 , 4, 4, 5};
        int[] arr3 ={2, 3, 3,  4,  5, 5, 6};

        findPairsToSum(arr, 9).forEach(p -> System.out.println(p[0] + " " + p[1]));
        System.out.println();
        findPairsToSum(arr2, 8).forEach(p -> System.out.println(p[0] + " " + p[1]));
        System.out.println();
        findPairsToSum(arr3, 8).forEach(p -> System.out.println(p[0] + " " + p[1]));
    }

}
