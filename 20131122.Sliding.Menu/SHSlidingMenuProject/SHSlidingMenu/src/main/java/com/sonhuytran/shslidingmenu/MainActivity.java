package com.sonhuytran.shslidingmenu;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.sonhuytran.shslidingmenu.adapter.DrawerMenuListAdapter;
import com.sonhuytran.shslidingmenu.model.DrawerMenuItem;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    //region Private Fields

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerMenu;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerMenuTitle;
    private CharSequence mTitle;
    private String[] mMenuTitles;
    private TypedArray mMenuIcons;
    private ArrayList<DrawerMenuItem> mMenuItems;
    private DrawerMenuListAdapter mAdapter;

    //endregion Private Fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }

        this.mTitle = this.mDrawerMenuTitle = this.getTitle();
        this.mMenuTitles = this.getResources().getStringArray(
                R.array.nav_drawer_items);
        this.mMenuIcons = this.getResources().obtainTypedArray(
                R.array.nav_drawer_icons);
        this.mDrawerLayout = (DrawerLayout) this.findViewById(
                R.id.drawer_layout);
        this.mDrawerMenu = (ListView) this.findViewById(R.id.list_slidermenu);
        this.mMenuItems = new ArrayList<DrawerMenuItem>();

        for (int i = 0; i < mMenuTitles.length
                && i < mMenuIcons.length(); i++) {
            this.mMenuItems.add(new DrawerMenuItem(
                    this.mMenuIcons.getResourceId(i, -1),
                    this.mMenuTitles[i]));
        }

        this.mMenuIcons.recycle();

        this.mAdapter = new DrawerMenuListAdapter(this, this.mMenuItems);
        this.mDrawerMenu.setAdapter(this.mAdapter);

        try {
            this.getActionBar().setDisplayHomeAsUpEnabled(true);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                this.getActionBar().setHomeButtonEnabled(true);
            }
        } catch (NullPointerException e) {
            Log.e("ActionBar", "Activity.getActionBar() returns null", e);
        }

        // The menu toggle button
        this.mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout,
                R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {


            public void onDrawerClosed(View view) {
                try {
                    MainActivity.this.getActionBar().setTitle(mTitle);
                } catch (NullPointerException e) {
                    Log.e("ActionBar", "Activity.getActionBar() returns null", e);
                }
                // calling onPrepareOptionsMenu() to show action bar icons
                MainActivity.this.invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                try {
                    MainActivity.this.getActionBar().setTitle(mDrawerMenuTitle);
                } catch (NullPointerException e) {
                    Log.e("ActionBar", "Activity.getActionBar() returns null", e);
                }
                // calling onPrepareOptionsMenu() to hide action bar icons
                MainActivity.this.invalidateOptionsMenu();
            }
        };

        this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            // displayView(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        this.getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(this.mDrawerMenu);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        this.mTitle = this.mDrawerMenuTitle = title;

        try {
            this.getActionBar().setTitle(title);
        } catch (NullPointerException e) {
            Log.e("ActionBar", "Activity.getActionBar() returns null", e);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            return rootView;
//        }
//    }

}
