package com.jtarun.practice.leetcode;

import java.util.*;

/** 929
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there
 * will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and
 * "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
 * (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually
 * receive mails?
 */
public class UniqueEmailAddress {

    private static class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> s = new HashSet<>();

            for (String email : emails) {
                String[] parts = email.split("@");
                String name = name(parts[0]), domain = parts[1];
                s.add(name+domain);
            }

            return s.size();
        }

        private String name(String name) {
            String[] parts = name.split("\\+");
            name = parts[0];
            parts = name.split(".");

            StringBuilder sb = new StringBuilder();
            for (String part : parts){
                sb.append(part);
            }
            return sb.toString();
        }
    }

}
