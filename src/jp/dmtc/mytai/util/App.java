package jp.dmtc.mytai.util;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ユーティリティ系
 */
public class App {
    private static App ourInstance = new App();

    public static App getInstance() {
        return ourInstance;
    }

    //region ページ遷移系
    /**
     * ページ遷移する。
     * @param thisPage 今のページ
     * @param destPage 行き先ページのClass
     */
    public static <T> void Transition(final Activity thisPage, final Class<T> destPage) {
        Intent intent = new Intent(thisPage, destPage);
        thisPage.startActivity(intent);
    }

    /**
     * Intentのフラグを指定してページ遷移する。
     * @param flags Intent.ACTIVITY_***
     */
    public static <T> void Transition(final Activity thisPage, final Class<T> destPage, int flags) {
        Intent intent = new Intent(thisPage.getApplication(), destPage);
        intent.setFlags(flags);
        thisPage.startActivity(intent);
    }

    /**
     * 指定したViewがクリックされたら指定したページに飛ぶようにする。
     *
     * @param viewId   ViewのID
     * @param destPage 行き先ページのClass
     * @param page     元のページ
     */
    public static <T> void SetTransition(final int viewId, final Class<T> destPage, final Activity page) {
        page.findViewById(viewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Transition(page, destPage);
            }
        });
    }

    /**
     * ViewのIDと行き先ページのClassのペアのリストを渡してページ遷移を設定する。
     *
     * @param pairs ViewのIDと行き先ページのClassのペアのリスト
     * @param page  　元のページ
     */
    public static <T> void SetTransition(final Iterable<Pair<Integer, Class<T>>> pairs, final Activity page) {
        for (final Pair<Integer, Class<T>> pair : pairs) {
            SetTransition(pair.first, pair.second, page);
        }
    }
    //endregion

    /**
     * 秒数と処理を指定して起動する非同期タイマー。
     * @param delay 単位はミリ秒
     * @param timerTask 実行する処理
     */
    public static void SetTimer(long delay, TimerTask timerTask) {
        Timer timer = new Timer(true);
        timer.schedule(timerTask, delay);
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
