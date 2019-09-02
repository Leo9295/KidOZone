package IE.D25.newlifeinau;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.List;

public class HomePage extends AppCompatActivity {

    String userSuburb;
    String userLat;
    String userLon;
    Context context = HomePage.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        Button shcoolLife = (Button) findViewById(R.id.button);

        ExternalIP externalIP= new ExternalIP();
        externalIP.execute();

        shcoolLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SchoolMap.class);
                Bundle currentUserInfo = new Bundle();
                currentUserInfo.putString("userSuburb", userSuburb);
                currentUserInfo.putString("userLat", userLat);
                currentUserInfo.putString("userLon", userLon);
                intent.putExtras(currentUserInfo);
                startActivity(intent);
            }
        });
    }


    public static String getIP(Context context) {

        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }



    private class ExternalIP extends AsyncTask<Void, Void, String> {

        protected String doInBackground(Void... urls) {
            return IpAPI.search(GetIP.getNetIp(context));
        }

        protected void onPostExecute(String result) {

            try {
                List<String> resultList = IpAPI.getInf(result);
                if (!resultList.get(0).equals("Australia")) {
                    Toast.makeText(HomePage.this, "Only for Australia user", Toast.LENGTH_SHORT).show();
                    System.exit(0);
                }

                userSuburb = resultList.get(1);
                userLat = resultList.get(2);
                userLon = resultList.get(3);
            } catch (Exception e) {
                e.printStackTrace();
                Toast toast = Toast.makeText(HomePage.this, "No Internet connection detected, Please try later.", Toast.LENGTH_LONG);
                toast.show();
            }
//            Bundle currentUserInfo = new Bundle();
//            currentUserInfo.putString("userSuburb", resultList.get(1));
//            currentUserInfo.putString("userLat", resultList.get(2));
//            currentUserInfo.putString("userLon", resultList.get(3));
//            getIntent().putExtras(currentUserInfo);
        }
    }




}


