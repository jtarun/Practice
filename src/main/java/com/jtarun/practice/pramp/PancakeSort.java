package com.jtarun.practice.pramp;

public class PancakeSort {

    private static class Solution {

        static void flip(int[] arr, int k) {
            int i = 0, j = k - 1;
            while (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }

        static int[] pancakeSort(int[] arr) {
            // your code goes here
            for (int i = 1; i < arr.length; i++) {

                int j = 0;
                while (j < i && arr[j] < arr[i]) j++;

                if (j < i) {
                    reverse(arr, j, i);
                    reverse(arr, j + 1, i);
                }

            }

            return arr;
        }

        //1, 3, 2, 1
        private static void reverse(int[] arr,
                                    int i, int j) {
            flip(arr, j + 1);
            flip(arr, j-i+ 1);
            flip(arr, j + 1);
        }
    }



        public static void main(String[] args) {
            Solution sol = new Solution();
            int[] res = sol.pancakeSort(new int[]{5,4,3,2,1});
            for (int x : res) System.out.println(x);
        }


}
