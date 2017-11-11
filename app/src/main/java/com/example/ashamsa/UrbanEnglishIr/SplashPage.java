package com.example.ashamsa.UrbanEnglishIr;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashamsa.recyclerviewtemplate.R;

public class SplashPage extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT  = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        setToFullScreen();
        getWindow().setBackgroundDrawableResource(R.drawable.welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = Level1_fragment_caller.newIntent(SplashPage.this);
                startActivity(intent);
                finish();

            }
        }, SPLASH_TIME_OUT);

    }


    private void setToFullScreen() {
        ViewGroup m_RootLayout= (ViewGroup) findViewById(R.id.id_splash);
        m_RootLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        setToFullScreen();
    }
}
