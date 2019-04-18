package com.jtarun.practice.interviewbit.string;

import java.util.ArrayList;
import java.util.Collections;

class Solution10 {
  public ArrayList<String> restoreIpAddresses(String a) {
    ArrayList<String> res = new ArrayList<>();

    restoreIpAddresses(a, 0, 4, "", res);

    Collections.sort(res);

    return res;
  }

  void restoreIpAddresses(String a, int i, int cnt, String cur, ArrayList<String> res) {
    if (i >= a.length() || cnt < 1) return;

    int num = 0;
    String sub = "";
    for (int j = i; j < a.length(); j++) {
      if ( j > i && a.charAt(i) == '0') break;

      num = num * 10 + (a.charAt(j) - '0');
      if (num > 255) break;

      sub = cur.isEmpty() ? a.substring(i, j+1) : cur + "." + a.substring(i, j+1);

      if (cnt == 1 && j == a.length() - 1) res.add(sub);
      else restoreIpAddresses(a, j+1, cnt-1, sub, res);
    }
  }
}

public class ValidIp {
  public static void main(String[] args) {
    Solution10 sol = new Solution10();
    sol.restoreIpAddresses("25525511135").forEach(System.out::println);
  }

}
