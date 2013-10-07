package jp.spinylobster.util;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * タブ選択時にFragmentクラスをinflateするTabListener。
 */
public class DefaultTabListener<T extends Fragment> implements ActionBar.TabListener {
    private Fragment fragment;
    private final Activity activity;
    private final String tag;
    private final Class<T> tClass;

    public DefaultTabListener(Activity activity, String tag, Class<T> tClass) {
        this.activity = activity;
        this.tag = tag;
        this.tClass = tClass;
        this.fragment = activity.getFragmentManager().findFragmentByTag(tag);
    }

    private void addFragment() {
        activity.getFragmentManager()
                .beginTransaction()
                .add(R.id.content, fragment, tag)
                .commit();
    }

    private void attachFragment() {
        activity.getFragmentManager()
                .beginTransaction()
                .attach(fragment)
                .commit();
    }

    private void detachFragment() {
        activity.getFragmentManager()
                .beginTransaction()
                .detach(fragment)
                .commit();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (fragment == null) {
            fragment = Fragment.instantiate(activity, tClass.getName());
            addFragment();
        }
        else if(fragment.isDetached()) {
            attachFragment();
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if(fragment != null) {
            detachFragment();
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
