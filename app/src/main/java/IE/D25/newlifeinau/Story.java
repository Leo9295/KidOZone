package IE.D25.newlifeinau;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Story extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);


        Button askingHelp = (Button) findViewById(R.id.ask);

        askingHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, AskHelp.class);
                startActivity(intent);
            }
        });

        Button staySafe = (Button) findViewById(R.id.stay);

        staySafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, StaySafe.class);
                startActivity(intent);
            }
        });


        Button noBullying = (Button) findViewById(R.id.nobullying);

        noBullying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, NoBullying.class);
                startActivity(intent);
            }
        });


        Button packageLunch = (Button) findViewById(R.id.packageLunch);

        packageLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, PackageLunch.class);
                startActivity(intent);
            }
        });


        Button makeFriend = (Button) findViewById(R.id.makefriend);

        makeFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, MakeFriend.class);
                startActivity(intent);
            }
        });

        Button fitIn = (Button) findViewById(R.id.fitIn);

        fitIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, WantFitIn.class);
                startActivity(intent);
            }
        });

        ImageButton askHelp = (ImageButton) findViewById(R.id.imageButtonAH);

        askHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, AskHelp.class);
                startActivity(intent);
            }
        });

        ImageButton staySafe1 = (ImageButton) findViewById(R.id.imageButtonSS);

        staySafe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, StaySafe.class);
                startActivity(intent);
            }
        });

        ImageButton noBully = (ImageButton) findViewById(R.id.imageButtonNB);

        noBully.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, NoBullying.class);
                startActivity(intent);
            }
        });

        ImageButton packageLunch1 = (ImageButton) findViewById(R.id.imageButtonLB);

        packageLunch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, PackageLunch.class);
                startActivity(intent);
            }
        });

        ImageButton makeFriend1 = (ImageButton) findViewById(R.id.imageButtonMF);

        makeFriend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, MakeFriend.class);
                startActivity(intent);
            }
        });

        ImageButton wantFitIn = (ImageButton) findViewById(R.id.imageButtonWF);

        wantFitIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Story.this, WantFitIn.class);
                startActivity(intent);
            }
        });
    }
}