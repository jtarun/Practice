package com.jtarun.practice;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class HttpTest2 {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpTest2 http = new HttpTest2();
        http.getCountries("in", 1000000);
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
        Long total_pages;
        Long total;
        List<Record> data;
    }

    private static class Record {
        String name;
        Long population;
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
            record.name = (String)o.get("name");
            record.population = (Long)o.get("population");
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

    static int getCountries(String s, int p) throws Exception {
        String baseurl = "https://jsonmock.hackerrank.com/api/countries/search?name="+s;
        String response = getRequest(baseurl);

        Res res = getResponse(response);
        int pages = res.total_pages.intValue();

        Set<String> visited = new HashSet<>();
        int ans = 0;
        int page = 1;
        while (page <= pages) {
            String url = baseurl + "&page=" + page;
            page++;
            response = getRequest(url);
            res = getResponse(response);

            //System.out.println(response);
            for (Record rec : res.data) {
                if (rec.population > p) {
                    if (visited.add(rec.name))ans++;
                }
            }
        }

        //System.out.println(ans);
        return ans;
    }



}

