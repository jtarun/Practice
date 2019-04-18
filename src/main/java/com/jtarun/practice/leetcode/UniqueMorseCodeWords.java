package com.jtarun.practice.leetcode;

import java.util.*;

/** 804
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 * as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
 * ".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * Return the number of different transformations among all words we have.
 *
 * Note:
 *
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 */
public class UniqueMorseCodeWords {

    private static class Solution {

        public int uniqueMorseRepresentations(String[] words) {
            String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
                    "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

            Set<String> s = new HashSet<>();
            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (int i  = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    sb.append(codes[c-'a']);
                }
                s.add(sb.toString());
            }

            return s.size();
        }
    }

}
