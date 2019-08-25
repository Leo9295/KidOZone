package IE.D25.newlifeinau;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class searchGoogleAPI {
    private static final String API_KEY = "AIzaSyBftyPOW_0YgGj9wczXDD7uCf_0mnK0rA4";
    private static final String SEARCH_ID_cx = "015107250200234319323:uqffarvi-mg";

    public static String search(String keyword, String[] params, String[] values) {
        keyword = keyword.replace(" ", "+");
        URL url = null;
        HttpURLConnection connection = null;
        String textResult = "";
        String query_parameter = "";
        if (params != null && values != null) {
            for (int i = 0; i < params.length; i++) {
                query_parameter += "&";
                query_parameter += params[i];
                query_parameter += "=";
                query_parameter += values[i];
            }
        }
        try {
            url = new URL("https://www.googleapis.com/customsearch/v1?key=" + API_KEY + "&cx=" + SEARCH_ID_cx + "&q=" + keyword + query_parameter);
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

    public static  List<String> getSnippet(String result) {
        List<String> result1 = new ArrayList<>();
        String snippet = null;
        String pagemap = null;
        String imgae = null;
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            if (jsonArray != null && jsonArray.length() > 0) {
                snippet = jsonArray.getJSONObject(0).getString("snippet");
                pagemap = jsonArray.getJSONObject(0).getString("pagemap");
                JSONObject jsonObject1 = new JSONObject(pagemap);
                JSONArray jsonArray1 = jsonObject1.getJSONArray("cse_image");
                if (jsonArray1 != null && jsonArray1.length() > 0) {
                    imgae = jsonArray1.getJSONObject(0).getString("src");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            snippet = "NO INFO FOUND";
        }
        result1.add(snippet);
        result1.add(imgae);
        return result1;
    }
}