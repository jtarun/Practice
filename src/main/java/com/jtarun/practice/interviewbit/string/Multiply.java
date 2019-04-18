package com.jtarun.practice.interviewbit.string;

class Solution5 {
  public String multiply(String a, String b) {

    int n1 = a.length();
    int n2 = b.length();
    if (n1<n2) {
      String t = a;
      a = b;
      b = t;
    }
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < b.length(); i++) {
      String val = mul(a, (int)(b.charAt(i) - '0'));
      if (i > 0) {
        res.append("0");
        res = add(res, val);
      } else res = new StringBuilder(val);
    }

    int k = 0;
    while (k < res.length()) {
      char c = res.charAt(k);
      if (c != '0') break;
      k++;
    }

    String out = res.toString();
    if ( k > 0 && k < out.length())
      out = out.substring(k, out.length() - k + 1);
    else if (k == out.length()) out = "0";
    return out;
  }

  String mul(String a, int digit) {
    StringBuilder res = new StringBuilder();
    int carry = 0;
    for(int i = a.length()-1; i>=0; i--) {
      int x = (int)(a.charAt(i) - '0');
      int mul = x * digit + carry;
      res.append(Integer.toString(mul % 10));
      carry = mul / 10;
    }

    if (carry > 0) {
      res.append(carry);
    }

    return res.reverse().toString();
  }

  StringBuilder add(StringBuilder a, String b) {

    StringBuilder res = new StringBuilder();

    int i = a.length()-1;
    int j = b.length()-1;
    int carry = 0;
    while ( i >= 0 &&  j>=0) {
      int sum = (int)(a.charAt(i) - '0') + (int)(b.charAt(j) - '0') + carry;
      res.append(Integer.toString(sum % 10));
      carry = sum/10;
      i--;
      j--;
    }

    while (i >= 0) {
      int sum = (int)(a.charAt(i) - '0') +  carry;
      res.append(Integer.toString(sum % 10));
      carry = sum/10;
      i--;
    }

    if (carry > 0) {
      res.append(carry);
    }

    return res.reverse();
  }


}



public class Multiply {

  public static void main(String[] args) {
    Solution5 sol = new Solution5();
    String add = sol.add(new StringBuilder("1993"), "456").toString();
    String mul = sol.mul("199", 9).toString();
    System.out.println(add);
    System.out.println(mul);

    String res1 = sol.multiply("5131848155574784703269632922904933776792735241197982102373370",
        "56675688419586288442134264892419611145485574406534291250836");

    String res = sol.multiply("08820630429040561575390435750496374086954522352294",
        "000697826988569335421188593345882896718338487540954558211321155541041788833007");
    System.out.println(res);
  }
}
