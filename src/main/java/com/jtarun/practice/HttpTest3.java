package com.jtarun.practice;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HttpTest3 {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpTest3.openAndClosePrices("1-January-2000", "22-February-2000", "Monday");
    }

    static String read(InputStream instream) throws Exception {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(instream));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private static class Res {
        Long page;
        Long per_page;
        Long total;
        Long total_pages;
        List<Record> data;
    }

    private static class Record {
        String date;
        double open;
        double close;
    }


    private static Res getResponse(String response) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject o = (JSONObject)parser.parse(response);

        Res res = new Res();
        long page;
        if (o.get("page") instanceof String) {
            page = Long.valueOf((String)o.get("page"));
        } else {
            page = (Long)o.get("per_page");
        }
        res.page = page;
        res.per_page = (Long)o.get("per_page");
        res.total_pages = (Long)o.get("total_pages");
        res.total = (Long)o.get("total");
        res.data = new ArrayList<>();
        JSONArray records = (JSONArray)o.get("data");
        Iterator<JSONObject> iterator = records.iterator();

        while (iterator.hasNext()) {
            o = iterator.next();
            Record record = new Record();
            record.date = (String)o.get("date");
            record.open =  Float.valueOf("" + o.get("open"));
            record.close = Float.valueOf("" + o.get("close"));
            res.data.add(record);
        }

        return res;
    }

    private static String getRequest(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        String response = read(con.getInputStream());
        return response;
    }

    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) throws Exception {
        String baseurl = "https://jsonmock.hackerrank.com/api/stocks";
        String response = getRequest(baseurl);

        Res res = getResponse(response);
        int pages = res.total_pages.intValue();
        SimpleDateFormat format =new SimpleDateFormat("dd-MMMMM-yyyy");
        Date startDate = format.parse(firstDate);
        Date endDate = format.parse(lastDate);


        Set<String> visited = new HashSet<>();
        int ans = 0;
        int page = 1;
        while (page <= pages) {
            String url = baseurl + "/?page=" + page;
            page++;
            response = getRequest(url);
            res = getResponse(response);

            for (Record rec : res.data) {
                Date date = format.parse(rec.date);
                if (date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0
                    && getDayofWeek(date).equals(weekDay)) {
                    System.out.println(rec.date + " " + String.valueOf((float)rec.open)
                            + " " + String.valueOf((float)rec.close));
                }
            }
        }

    }

    private static String getDayofWeek(Date date) {
        DateFormat format =new SimpleDateFormat("EEEE");
        String day = format.format(date);
        return day;
    }



}

