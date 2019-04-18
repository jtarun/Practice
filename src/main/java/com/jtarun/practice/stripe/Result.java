package com.jtarun.practice.stripe;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    private static class Charge {
        private final Integer amount;
        private final String cardCountry;
        private final String currency;
        private final String ipCountry;

        public Charge(int amount, String cardCountry, String currency, String ipCountry) {
            this.amount = amount;
            this.cardCountry = cardCountry;
            this.currency = currency;
            this.ipCountry = ipCountry;
        }

        public Integer getAmount() {
            return amount;
        }

        public String getCardCountry() {
            return cardCountry;
        }

        public String getCurrency() {
            return currency;
        }

        public String getIpCountry() {
            return ipCountry;
        }
    }

    /*
     * Complete the 'should_allow_charge' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts STRING_ARRAY charge_and_rules as parameter.
     */

    public static boolean should_allow_charge(List<String> charge_and_rules) {
        String chargeStr = charge_and_rules.get(0);
        Charge charge = parseCharge(chargeStr);

        boolean res =  true;
        for (int i = 1; i < charge_and_rules.size(); i++) {
            String rule = charge_and_rules.get(i);
            int ind = rule.indexOf(':');
            String ruleType = rule.substring(0, ind).trim();
            String ruleDef = rule.substring(ind + 1).trim();

            boolean ruleResult = evaluate(charge, ruleDef);

            if (ruleResult) {
                res = ruleType.equals("ALLOW");
                break;
            }

        }

        return res;
    }

    private static boolean evaluate(Charge charge, String rule) {
        String[] ruleParts;
        String operator = "";

        // Compound AND
        if (rule.contains("AND")) {
            ruleParts = rule.split("AND");
            operator = "AND";
        } else { // Compound OR or single operand
            ruleParts = rule.split("OR");
            operator = "OR";
        }

        boolean res;
        if (operator.equals("AND")) {
            res = true;
            for (String rulePart : ruleParts) {
                if (!evaluatePart(charge, rulePart)) {
                    res = false;
                    break;
                }
            }
        } else {
            res = false;
            for (String rulePart: ruleParts) {
                if (evaluatePart(charge, rulePart)) {
                    res = true;
                    break;
                }
            }
        }

        return res;
    }

    private static boolean evaluatePart(Charge charge, String rule) {
        rule = rule.trim();
        String comparator = "";
        String[] operands;
        if (rule.contains("==")) {
            comparator = "==";
        } else if (rule.contains("!=")) {
            comparator = "!=";
        } else if (rule.contains("<=")) {
            comparator = "<=";
        } else if (rule.equals("<")) {
            comparator = "<";
        } else if (rule.equals(">=")) {
            comparator = ">=";
        } else {
            comparator = ">";
        }

        operands = rule.split(comparator);

        String key = operands[0].trim();
        String value = operands[1].trim();

        boolean res = false;
        if (key.equals("amount")) {
            Integer val = Integer.valueOf(value);
            Integer amount = charge.getAmount();
            int cmp = Integer.compare(amount, val);
            // Do integer comparision.
            if (comparator.equals("==")) {
                res = amount.equals(val);
            } else if (comparator.equals("<=")) {
                res = cmp <= 0;
            } else if (comparator.equals("<")) {
                res = cmp < 0;
            } else if (comparator.equals(">=")) {
                res = cmp >= 0;
            } else  {
                res = cmp > 0;
            }
        } else if (key.equals("currency")) {
            String currency = charge.getCurrency();
            res = currency.equals(value);
            if (comparator.equals("!=")) res = !res;
        } else if (key.equals("ip_country")){

            String ipCountry = charge.getIpCountry();
            if (value.equals("card_country")) {
                res = ipCountry.equals(charge.getCardCountry());
            } else {
                res = ipCountry.equals(value);
            }
            if (comparator.equals("!=")) res = !res;
        } else {
            String ipCountry = charge.getIpCountry();
            if (value.equals("ip_country")) {
                res = ipCountry.equals(charge.getIpCountry());
            } else {
                res = ipCountry.equals(value);
            }
            if (comparator.equals("!=")) res = !res;
        }

        return res;
    }

    private static Charge parseCharge(String str) {
        String[] parts = str.split("&");
        int amount = 0;
        String cardCountry = "";
        String currency = "";
        String ipCountry = "";
        for (String part : parts) {
            String[] pair = part.split("=");
            String key = pair[0].trim();
            String value = pair[1].trim();

            if (key.equals("card_country")) {
                cardCountry = value;
            } else if (key.equals("currency")) {
                currency = value;
            } else if (key.equals("amount")) {
                amount = Integer.valueOf(value);
            } else if (key.equals("ip_country")) {
                ipCountry = value;
            }
        }

        return new Charge(amount, cardCountry, currency, ipCountry);

    }

}