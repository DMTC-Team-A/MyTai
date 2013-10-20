package jp.dmtc.mytai;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import jp.dmtc.mytai.util.App;
import jp.dmtc.mytai.util.DefaultTabListener;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        App.setActionBarBotton(this);

        final ActionBar actionBar = getActionBar();

        actionBar.addTab(actionBar
                .newTab()
                .setText("Tab1")
                .setTabListener(new DefaultTabListener<TabFragment1>(
                        this, "tag1", TabFragment1.class))
        );
        actionBar.addTab(actionBar
                .newTab()
                .setText("Tab2")
                .setIcon(R.drawable.windows8)
                .setTabListener(new DefaultTabListener<TabFragment2>(
                        this, "tag2", TabFragment2.class))
        );

    }
}
