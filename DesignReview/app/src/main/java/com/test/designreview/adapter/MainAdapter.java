package com.test.designreview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Created by kingwag on 2016/11/29.
 */

public class MainAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> strings;
    public MainAdapter(FragmentManager fm,List<String> strings,List<Fragment> fragments) {
        super(fm);
        this.strings = strings;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
