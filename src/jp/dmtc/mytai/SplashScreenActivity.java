package jp.dmtc.mytai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import jp.dmtc.mytai.util.App;

import java.util.TimerTask;

/**
 * スプラッシュスクリーンのページ
 */
public class SplashScreenActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        //二秒後にMainActivityに飛ぶ
        App.SetTimer(2000, new TimerTask() {
            @Override
            public void run() {
                App.Transition(SplashScreenActivity.this, MyActivity.class,
                        Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                SplashScreenActivity.this.finish();
            }
        });
    }
}
