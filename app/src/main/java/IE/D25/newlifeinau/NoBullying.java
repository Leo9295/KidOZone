package IE.D25.newlifeinau;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class NoBullying extends AppCompatActivity {

    ViewPager viewPager;
    slideAdapter3 adapter;
    LinearLayout sliderDots;
    private int dotCounts;
    private ImageView[] dots;
    private MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_bullying);
        viewPager = findViewById(R.id.viewPager);
        adapter = new slideAdapter3(this);
        viewPager.setAdapter(adapter);

        sliderDots = findViewById(R.id.SliderDots);

        dotCounts = adapter.getCount();
        dots = new ImageView[dotCounts];
        for (int i = 0; i < dotCounts; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slide_nonactive));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 2, 8, 0);
            sliderDots.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slide_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotCounts; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slide_nonactive));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slide_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new NoBullying.MyTimerTask(), 6000, 6000);

        Button quiz = (Button) findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }


    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.school);
        builder.setTitle("      Correct or False?");
        builder.setMessage("          Say no to bullying.");
        builder.setPositiveButton("Correct",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Display display = getWindowManager().getDefaultDisplay();
                        int height = display.getHeight();
                        Toast toast = Toast.makeText(NoBullying.this, "Wonderful!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP, 0, 5 * (height / 8));
                        toast.show();
                        MediaPlayer mp = MediaPlayer.create(NoBullying.this, R.raw.wonderful);
                        mp.start();
                    }
                });
        builder.setNeutralButton("Error", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Display display = getWindowManager().getDefaultDisplay();
                int height = display.getHeight();
                Toast toast = Toast.makeText(NoBullying.this, "No, keep away from bullying.", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 5 * (height / 8));
                toast.show();
                MediaPlayer mp = MediaPlayer.create(NoBullying.this, R.raw.tryagain);
                mp.start();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();

        p.gravity = Gravity.CENTER;

        p.alpha = 0.8f;
        dialogWindow.setAttributes(p);

    }

    private class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            NoBullying.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}