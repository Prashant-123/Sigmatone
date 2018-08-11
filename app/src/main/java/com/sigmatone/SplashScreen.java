package com.sigmatone;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;
import com.hanks.htextview.fade.FadeTextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000; //Time duration for Splash Screen
    private FadeTextView hTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        hTextView = findViewById(R.id.textView);
        hTextView.setAnimationListener(new SimpleAnimationListener(this));
        hTextView.animateText(getString(R.string.app_name));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    //Text Animator.
    class SimpleAnimationListener implements AnimationListener {
        private Context context;
        public SimpleAnimationListener(Context context) {
            this.context = context;
        }
        @Override
        public void onAnimationEnd(HTextView hTextView) {

        }
    }
}
