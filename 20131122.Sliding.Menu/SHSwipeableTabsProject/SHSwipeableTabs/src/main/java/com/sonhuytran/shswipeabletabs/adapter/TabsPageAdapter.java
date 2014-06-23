package com.sonhuytran.shswipeabletabs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Son-Huy TRAN on 25/11/13.
 */
public class TabsPageAdapter extends FragmentPagerAdapter {

    //region Construction

    public TabsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    //endregion Construction

    //region FragmentPagerAdapter implementation

    @Override
    public Fragment getItem(int index) {
        switch (index) {

        }

        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    //endregion FragmentPagerAdapter implementation
}