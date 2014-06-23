package com.sonhuytran.shswipeabletabs;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.sonhuytran.shswipeabletabs.adapter.TabsPageAdapter;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    //region Private Fields

    private ViewPager viewPager;
    private ActionBar actionBar;
    private TabsPageAdapter mAdapter;
    //Tabs' title
    private String[] tabTitles = {"Tous", "En cours", "Envoyé", "Payé"};

    //endregion Private Fields

    //region FragmentActivity implementation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        //Initialization
        this.mAdapter = new TabsPageAdapter(this.getSupportFragmentManager());

        this.viewPager = (ViewPager) this.findViewById(R.id.pager);
        this.viewPager.setAdapter(this.mAdapter);

        this.actionBar = this.getActionBar();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            this.actionBar.setHomeButtonEnabled(true);
        }

        this.actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Adding tabs
        for (String tabTitle : tabTitles) {
            //Create a new tab
            ActionBar.Tab tab = this.actionBar.newTab();
            tab.setText(tabTitle);
            tab.setTabListener(this);

            //Add the new tab
            this.actionBar.addTab(tab);
        }
    }

    //endregion FragmentActivity implementation

    //region ActionBar.TabListener implementation

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    //endregion ActionBar.TabListener implementation
}
