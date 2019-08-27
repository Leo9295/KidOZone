package IE.D25.newlifeinau;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IpAPI {
    public static String search(String keyword) {

        URL url = null;
        HttpURLConnection connection = null;
        String textResult = "";

        try {
            url = new URL("http://ip-api.com/json/" + keyword);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                textResult += scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return textResult;
    }

    public static List<String> getInf(String result) {
        List<String> result1 = new ArrayList<>();
        String country = null;
        String surburb = null;
        String lat = null;
        String lon = null;
        try {
            JSONObject jsonObject = new JSONObject(result);
            String status = jsonObject.getString("status");
            if (status.equals("success")) {
                country = jsonObject.getString("country");
                surburb = jsonObject.getString("city");
                lat = jsonObject.getString("lat");
                lon = jsonObject.getString("lon");
            }
        } catch (Exception e) {
            e.printStackTrace();
            country = "Null1";
            surburb = "Null1";
            lat = "Null1";
            lon = "Null1";
        }
        result1.add(country);
        result1.add(surburb);
        result1.add(lat);
        result1.add(lon);
        return result1;
    }


}
