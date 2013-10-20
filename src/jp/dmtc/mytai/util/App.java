package jp.dmtc.mytai.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * ユーティリティ系
 */
public class App {
    private static App ourInstance = new App();

    public static App getInstance() {
        return ourInstance;
    }

    /**
     * アクションバーを画面の下に置く。色々決め打ちなので後々これが原因のエラーが出るかも。
     */
    public static void setActionBarBotton(Activity page) {
        ViewGroup root = (ViewGroup) page.getWindow().getDecorView();
        LinearLayout rootLinearLayout = (LinearLayout) root.getChildAt(0);
        View ab = rootLinearLayout.getChildAt(0);
        rootLinearLayout.removeView(ab);
        rootLinearLayout.addView(ab, 1);
    }

    private App() {
    }
}
