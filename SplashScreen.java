package com.mobile.taskmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import java.util.Random;

public class SplashScreen extends AppCompatActivity {

    Thread splashTread;
  //  CardView myLogo;
  //  private ApiController appController;
    LinearLayout LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random randomGenerator = new Random();

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        LL = (LinearLayout) findViewById(R.id.lin_lay);
        //myLogo = (CardView)findViewById(R.id.bankLogo);
      //  appController = new ApiController();
        splashTread = new Thread() {
            @Override
            public void run() {
                try {

                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                    LL.startAnimation(animation);
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 700) {
                        sleep(300);
                        waited += 100;
                    }

                    Intent intent = new Intent(SplashScreen.this,
                            Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    SplashScreen.this.finish();

                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashScreen.this.finish();
                }

            }
        };
        splashTread.start();
    }

}

