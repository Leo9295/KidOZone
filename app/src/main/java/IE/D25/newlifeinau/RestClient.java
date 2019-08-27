package IE.D25.newlifeinau;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestClient {

    /**
     *
     * @param suburbName
     * @return json list of string
     */
    public static String getSchoolInfo(String suburbName){
        URL url = null;
        HttpURLConnection connection = null;
        String jsonString = "";
        suburbName = suburbName.toUpperCase();

        try{
            url = new URL("http://3.105.242.54:3000/school?suburb=" + suburbName);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                jsonString += scanner.nextLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return jsonString;
    }

    public static List<SchoolInfo> parseSchoolJson(String schoolJson){
        List<SchoolInfo> schoolInfos = new ArrayList<SchoolInfo>();
        try{
            JSONArray jsonArray = new JSONArray(schoolJson);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                SchoolInfo info = new SchoolInfo();
                info.setSchoolName(obj.getString("school_name"));
                info.setSchoolAddress(obj.getString("address_line"));
                info.setSchoolPhone(obj.getString("full_phone_no"));
                info.setSchoolSuburb(obj.getString("suburb"));
                info.setSchoolPostcode(obj.getString("postal_postcode"));
                double lat = Double.parseDouble(obj.getString("latitude"));
                double lon = Double.parseDouble(obj.getString("longitude"));
                Coordinate coo = new Coordinate(lon, lat);
                info.setSchoolCoordinate(coo);
                schoolInfos.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return schoolInfos;
    }
}
