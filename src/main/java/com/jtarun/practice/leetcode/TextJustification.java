package com.jtarun.practice.leetcode;

import java.util.*;

/** 68
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth
 * characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line
 * do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots
 * on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 */
public class TextJustification {

    private static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();

            int i = 0;
            while (i < words.length) {

                int j = i + 1;
                int len = words[i].length();
                while (j < words.length && (len + 1 + words[j].length()) <= maxWidth) {
                    len = len + 1 + words[j].length();
                    j++;
                }
                int wordCnt = j-i;
                char[] line = new char[maxWidth];
                Arrays.fill(line, ' ');
                int left = maxWidth - len;

                int spaces = j < words.length ? (wordCnt > 1 ? 1 + left / (wordCnt-1) : 0) : 1 ;
                int rem = j < words.length ? (wordCnt > 1 ? (left % (wordCnt-1)) : 0) : 0;
                int cnt = 0, k = 0;
                while (cnt < wordCnt) {
                    if (cnt != 0) {
                        k += spaces + (rem > 0 ? 1 : 0);
                        rem--;
                    }
                    String word = words[i+cnt];
                    for (int l = 0; l < word.length(); l++) line[k++] = word.charAt(l);

                    cnt++;
                }

                res.add(new String(line));
                i = j;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        sol.fullJustify(words, 16).forEach(System.out::println);
    }

}
