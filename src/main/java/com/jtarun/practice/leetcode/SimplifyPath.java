package com.jtarun.practice.leetcode;

import java.util.*;

/** 71
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/a/../../b/../c//.//", => "/c"
 * path = "/a//b////c/d//././/..", => "/a/b/c"
 *
 * In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a
 * simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the
 * last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {

    private static class Solution {
        public String simplifyPath(String path) {
            Stack<String> st = new Stack<>();
            int i = 0;
            while (i < path.length()) {

                while (i < path.length() && path.charAt(i) == '/') i++;
                if (i == path.length()) break;

                int j = i;
                while (j < path.length() && path.charAt(j) != '/') j++;

                String token = path.substring(i, j);
                if (token.equals("..")) {
                    if (!st.isEmpty()) st.pop();
                } else if (token.equals(".")) {
                } else {
                    st.push(token);
                }

                i = j;
            }

            if (st.isEmpty()) return "/";

            Stack<String> s = new Stack<>();
            while (!st.isEmpty()) s.push(st.pop());

            StringBuilder res = new StringBuilder();
            while (!s.isEmpty()) res.append('/').append(s.pop());

            return res.toString();
        }
    }

}
