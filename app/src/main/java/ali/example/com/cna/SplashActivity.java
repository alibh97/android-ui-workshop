package ali.example.com.cna;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    Animation rotate,dance,up;
    Button login;
    ProgressBar marsPb;

    View orange;
    View black;
    int i = 0;

    CountDownTimer wait, timer,t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        login = findViewById(R.id.login_button);
        marsPb = findViewById(R.id.progressbar);
        black = findViewById(R.id.black_bg);
        orange = findViewById(R.id.orange_bg);

        up = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        login.setVisibility(View.INVISIBLE);
        spinner();
    }
    public void spinner(){
        wait = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                timer = new CountDownTimer(900, 1) {
                    @Override
                    public void onTick(long l) {
                        black.getLayoutParams().width = 2000 - i;
                        black.requestLayout();
                        i += 150;
                    }

                    @Override
                    public void onFinish() {
                        i = 0;
                        t = new CountDownTimer(600, 1) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                orange.getLayoutParams().height = 3000 - i;
                                orange.requestLayout();
                                i += 300;
                            }

                            @Override
                            public void onFinish() {
                                CountDownTimer timer = new CountDownTimer(3000,1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        marsPb.setVisibility(View.INVISIBLE);
                                        login.startAnimation(up);
                                        login.setVisibility(View.VISIBLE);

                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
    }
}
