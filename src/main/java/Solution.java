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

    /*
     * Complete the 'reformatDate' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY dates as parameter.
     */
    public static List<String> reformatDate(List<String> dates) {
        String[] months= {"Jan","Feb", "Mar", "Apr", "May","Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "12"};
        Map<String, String> monthCache = new HashMap<>();
        for (int i = 1; i <= months.length; i++) {
            String num = i < 10 ? "0" + i : ""+i;
            monthCache.put(months[i-1], num);
        }

        List<String> res = new ArrayList<>();
        for (String date : dates) {
            res.add(format(date, monthCache));
        }
        return res;
    }

    private static String format(String date, Map<String, String> monthCache) {
        String[] parts = date.split(" ");
        int day = extractDay(parts[0].trim());
        String month = monthCache.get(parts[1].trim());
        String year = parts[2].trim();

        return year + "-" + month + "-" + (day < 10 ? "0" +day : ""+day);
    }

    private static int extractDay(String dayStr) {
        int i = 0;
        while (i < dayStr.length() && dayStr.charAt(i) >= '0' && dayStr.charAt(i) <= '9') {
            i++;
        }
        return Integer.valueOf(dayStr.substring(0, i));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dates = IntStream.range(0, datesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());*/

        List<String> dates = new ArrayList<>();
        dates.add("1st Mar 1989");

        List<String> result = Result.reformatDate(dates);

        result.forEach(System.out::println);

/*        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

