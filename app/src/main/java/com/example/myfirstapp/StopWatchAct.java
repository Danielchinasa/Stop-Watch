package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class StopWatchAct extends AppCompatActivity {


    Button btnStart, btnStop;
    Animation roundingslone;
    ImageView icanchor;
    Chronometer timeHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        icanchor = findViewById(R.id.icanchor);
        timeHere = findViewById(R.id.timerHere);


        // create optional animation
        btnStop.setAlpha(0);

        // load animation
        roundingslone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);


        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        // customize font
        btnStart.setTypeface(MMedium);
        btnStop.setTypeface(MLight);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing animation
                icanchor.startAnimation(roundingslone);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();

                // start Time
                timeHere.setBase(SystemClock.elapsedRealtime());
                timeHere.start();
            }
        });
    }
}
