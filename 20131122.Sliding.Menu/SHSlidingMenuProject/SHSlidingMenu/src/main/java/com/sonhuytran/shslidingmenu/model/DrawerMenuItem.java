package com.sonhuytran.shslidingmenu.model;

/**
 * Created by Son-Huy TRAN on 22/11/13.
 */
public class DrawerMenuItem {

    //region Private Fields

    private int mIcon;
    private String mTitle;
    private String mCount = "0";
    private boolean mCounterVisible = false;

    //endregion Private Fields

    //region Public Properties

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        this.mIcon = icon;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getCount() {
        return mCount;
    }

    public void setCount(String count) {
        this.mCount = count;
    }

    public boolean isCounterVisible() {
        return mCounterVisible;
    }

    public void setCounterVisible(boolean counterVisible) {
        this.mCounterVisible = counterVisible;
    }

    //endregion Public Properties

    //region Constructions

    public DrawerMenuItem() {
    }

    public DrawerMenuItem(int icon, String title) {
        this.mIcon = icon;
        this.mTitle = title;
    }

    public DrawerMenuItem(int icon, String title, String count, boolean counterVisible) {
        this.mIcon = icon;
        this.mTitle = title;
        this.mCount = count;
        this.mCounterVisible = counterVisible;
    }

    //endregion Constructions
}
