package IE.D25.newlifeinau;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SchoolMap  extends AppCompatActivity {

    TextView schoolName1;
    TextView schoolName2;
    TextView distance2School1;
    TextView distance2School2;
    double userLat;
    double userLon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schoolmap);

        schoolName1 = (TextView) findViewById(R.id.schoolName1);
        schoolName2 = (TextView) findViewById(R.id.schoolName2);
        distance2School1 = (TextView)  findViewById(R.id.distance2School1);
        distance2School2 = (TextView)  findViewById(R.id.distance2School2);
        Button story = (Button) findViewById(R.id.button2);

        Bundle userInfoBundle = this.getIntent().getExtras();

        schoolName1.bringToFront();
        schoolName2.bringToFront();
        distance2School1.bringToFront();
        distance2School2.bringToFront();

        //Bundle userInfoBundle = this.getIntent().getExtras();
        String currentUserSuburb = userInfoBundle.getString("userSuburb");
        String userLat1 = userInfoBundle.getString("userLat");
        String userLon1 = userInfoBundle.getString("userLon");
        try {
            if (!userLat1.isEmpty() && !userLon1.isEmpty()) {
                userLat = Double.parseDouble(userInfoBundle.getString("userLat"));
                userLon = Double.parseDouble(userInfoBundle.getString("userLon"));
            } else {
                userLat = 0.0;
                userLon = 0.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast toast = Toast.makeText(SchoolMap.this, "Something goes wrong! please try it later~", Toast.LENGTH_LONG);
            toast.show();
        }

        SchoolInfoAchieve schoolInfoAchieve = new SchoolInfoAchieve();
        schoolInfoAchieve.execute(currentUserSuburb);

        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolMap.this, Story.class);
                startActivity(intent);
            }
        });
    }

    private class SchoolInfoAchieve extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return RestClient.getSchoolInfo(strings[0]);
        }

        @Override
        protected void onPostExecute(String result){
            List<SchoolInfo> schoolList = RestClient.parseSchoolJson(result);
            SystemUtil util = new SystemUtil();
            Coordinate currentCoordinate = new Coordinate(userLat, userLon);
            if (schoolList.size() == 1) {
                schoolName1.setText(schoolList.get(0).getSchoolName());
                distance2School1.setText(util.distance4UserAndSchoolCal(currentCoordinate, schoolList.get(0).getSchoolCoordinate()) + "km");
                schoolName2.setText("");
                distance2School2.setText("");
            } else if(schoolList.size() == 0) {
                schoolName1.setText("");
                schoolName2.setText("");
                distance2School1.setText("");
                distance2School2.setText("");
                Toast toast = Toast.makeText(SchoolMap.this, "We can't get your location information, Please try later.", Toast.LENGTH_LONG);
                toast.show();
            }else {
                schoolName1.setText(schoolList.get(0).getSchoolName());
                distance2School1.setText(util.distance4UserAndSchoolCal(currentCoordinate, schoolList.get(0).getSchoolCoordinate()) + "km");
                schoolName2.setText(schoolList.get(1).getSchoolName());
                distance2School2.setText(util.distance4UserAndSchoolCal(currentCoordinate, schoolList.get(1).getSchoolCoordinate()) + "km");
            }
        }
    }
}
