/*
 * ************************************************************************
 *  ADOBE CONFIDENTIAL
 *  ___________________
 *
 *   Copyright 2017 Adobe Systems Incorporated
 *   All Rights Reserved.
 *
 *  NOTICE:  All information contained herein is, and remains
 *  the property of Adobe Systems Incorporated and its suppliers,
 *  if any.  The intellectual and technical concepts contained
 *  herein are proprietary to Adobe Systems Incorporated and its
 *  suppliers and are protected by all applicable intellectual property
 *  laws, including trade secret and copyright laws.
 *  Dissemination of this information or reproduction of this material
 *  is strictly forbidden unless prior written permission is obtained
 *  from Adobe Systems Incorporated.
 * ************************************************************************
 */

package com.jtarun.practice.important.string;

import java.util.Arrays;

public class Counting {

  static Character kthNonRepeating(String str, int k) {
    int[] count = new int[256];
    int[] index = new int[256];

    int n = str.length();
    for (int i = 0; i < 256; i++) {
      count[i] = 0;
      index[i] = n;
    }

    for (int i = 0; i < n; i++) {
      int ind = str.charAt(i);
      if (count[ind] == 0) {
        index[ind] = i;
        count[ind]++;
      } else if (count[ind] > 0) {
        index[ind] = n;
      }
    }

    Arrays.sort(index);

    if (index[k - 1] == n) {
      System.out.println("No such character");
      return null;
    } else {
      Character c = str.charAt(index[k - 1]);
      System.out.println("Character is : " + c);
      return c;
    }
  }

  static int numberOfSubstrWithExactlyKDistinctChars(String str, int k) {
    int res = 0;

    for (int i = 0; i < str.length(); i++) {
      int[] hash = new int[256];
      Arrays.fill(hash, 0);
      int count = 0;
      for (int j = i; j < str.length(); j++) {
        int c = str.charAt(j);
        if (hash[c] == 0) {
          count++;
          hash[c]++;
        }
        if (count == k) {
          res++;
        } else if (count > k) {
          break;
        }
      }
    }

    return res;
  }

  private static char toLower(char c) {
    if (c >= 'A' && c <= 'Z') {
      return (char) (c + 32);
    }
    return c;
  }

  static int countCharsAtSamePos(String str) {
    int res = 0;
    for (int i = 0; i < str.length() && i < 26; i++) {
      char c = toLower(str.charAt(i));
      if ((c - 'a') == i) {
        res++;
      }
    }
    return res;
  }

  static char findKthDecryptedChar(String str, int k) {
    // Extract the string into two list of tokens with list1 containing substr and list2 freq.
    // multiply the substr length with freq. Then create a cumulative sum array cum[].
    // do binary search in the cum[] to find the first index i where val > k.
    // subtract cum[i] with cum[i-1] to get the exact character in ith substring.
    // list1[i][k % list1[i].length]
    return 'z';
  }

  static char maxConsecutiveRepeatedChar(String str) {
    int n = str.length();
    int i = 0;
    char res = '\0';
    int maxCnt = 0;
    while ( i < n ) {
      int cnt = 1;
      int j = i + 1;
      while (j < n && str.charAt(j) == str.charAt(i)) {
        cnt++;
      }

      if (cnt > maxCnt) {
        maxCnt = cnt;
        res = str.charAt(i);
      }
      i = i + cnt;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("KthNonRepeatingCharacter -----");
    String kthNonRepeating = "abcdefabcf";
    kthNonRepeating(kthNonRepeating, 2);
    kthNonRepeating(kthNonRepeating, 1);
    kthNonRepeating(kthNonRepeating, 3);
    System.out.println("------------------------------");

    String ch = "abcbaa";
    int k = 3;
    System.out.println("Total substrings with exactly " +
        k + " distinct characters : "
        + numberOfSubstrWithExactlyKDistinctChars(ch, k));

    System.out.println("------------------------------");

    System.out.println("characters at same pos : " + countCharsAtSamePos("abCEZF"));

    System.out.println("-------------------------------");

  }
}
