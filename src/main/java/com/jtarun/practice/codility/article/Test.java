package com.jtarun.practice.codility.article;

import org.springframework.cglib.core.Local;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {

    static class Solution {
        public String[] solution(String S, int[] B, int[] C) throws Exception {
            String[] parts = S.split("at");
            String dateStr = parts[0].trim();
            String timeStr = parts[1].trim();

            // check time is greater than 12 PM
            boolean greaterThan12pm = timeStr.toLowerCase().contains("pm");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate date = LocalDate.parse(dateStr, formatter);

            int earliest = B[0] + C[0];
            int latest = B[1] + C[1];

            LocalDate earlyDate = date.plusDays(earliest);
            if (greaterThan12pm && earliest == 0) {
                earlyDate = earlyDate.plusDays(1);
            }

            LocalDate lateDate = date.plusDays(B[1]);
            lateDate = addBusinessDays(lateDate, C[1]);

            String earlyDateStr = format(earlyDate);
            String lateDateStr = format(lateDate);


            return new String[]{earlyDateStr, lateDateStr};
        }

        private static String format(LocalDate date) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return date.format(formatter).toString();
        }

        private static LocalDate addBusinessDays(LocalDate date, int days) {

            if (days < 1) {
                return date;
            }

            LocalDate result = date;
            int counter = 0;
            while (counter < days) {
                if (!isWeekend(date)) {
                    counter++;
                }
                date = date.plusDays(1);
            }

            return result;
        }

        private static boolean isWeekend(LocalDate date) {
            return date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    date.getDayOfWeek() == DayOfWeek.SUNDAY;
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String o1 = "2018.11.06 at 08:30:00 AM";
        String[] ans = solution.solution(o1, new int[]{0, 2}, new int[]{0, 3});
        for (String d : ans) {
            System.out.println(d);
        }
    }

}
