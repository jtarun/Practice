package com.jtarun.practice.interviewbit.hashing;

import java.util.HashMap;

class Solution2 {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";

    boolean sign = (numerator < 0) ^ (denominator < 0);
    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);
    long decimal = num / den;

    long rem = num % den;
    if (rem == 0) {
      String numStr = Long.toString(decimal);
      return sign ? "-" +  numStr : numStr ;
    }


    HashMap<Integer, Integer> seen = new HashMap();
    boolean rec = false;
    StringBuilder fractionBuilder = new StringBuilder();
    int index = 0;
    int div;
    do {
      div = (int)((rem * 10) / den);
      rem = (rem * 10) % den;
      if (seen.containsKey((int)rem)) {
        rec = true;
        break;
      }
      fractionBuilder.append( div);
      seen.put((int)rem, index);
      index++;
    } while (rem!= 0 );

    String fraction = fractionBuilder.toString();
    if (rec){
      int ind = seen.get((int)rem);
      fraction = fraction.substring(0, ind) + "(" + fraction.substring(ind, fraction.length()) + ")";
    }

    String res = decimal + "." + fraction;
    if (sign) {
      res = "-" + res;
    }

    return res;
  }

}


public class Fraction {
  public static void main(String[] args) {
    Solution2 sol = new Solution2();
    System.out.println(sol.fractionToDecimal(87, 22));
  }
}
