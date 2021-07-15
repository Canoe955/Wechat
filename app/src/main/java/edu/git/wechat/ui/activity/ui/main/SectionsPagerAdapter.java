package edu.git.wechat.ui.activity.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import edu.git.wechat.ui.fragment.bottom.AccountFragment;
import edu.git.wechat.ui.fragment.bottom.ContactFragment;
import edu.git.wechat.ui.fragment.bottom.ExploreFragment;
import edu.git.wechat.ui.fragment.bottom.MessageFragment;
import edu.git.wechat.ui.fragment.other.TabConAndBottomFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final String[] TAB_TITLES = new String[]{"关注","推荐","本地","小视频"};
    private final Context mContext;
    private static final Fragment[] fragments = new Fragment[]{
        new MessageFragment(),
        new TabConAndBottomFragment(),
        new ExploreFragment(),
        new AccountFragment()
    };

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}