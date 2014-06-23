package com.sonhuytran.shslidingmenu.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonhuytran.shslidingmenu.R;
import com.sonhuytran.shslidingmenu.model.DrawerMenuItem;

import java.util.ArrayList;

/**
 * Created by Son-Huy TRAN on 22/11/13.
 */
public class DrawerMenuListAdapter extends BaseAdapter {

    //region Private Fields

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<DrawerMenuItem> mItems;

    //endregion Private Fields

    //region Constructions

    public DrawerMenuListAdapter(Context context,
                                 ArrayList<DrawerMenuItem> items) {
        this.mContext = context;

        if (null != context) {
            this.mInflater = (LayoutInflater) context.getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);
        }

        this.mItems = items;
    }


    //endregion Constructions

    //region BaseAdapter implementation

    @Override
    public int getCount() {
        try {
            return this.mItems.size();
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "getCount", e);
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        try {
            return this.mItems.get(position);
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "getItem", e);
            return new DrawerMenuItem();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView && null != this.mInflater) {
            convertView = this.mInflater.inflate(R.layout.drawer_menu_item, null);
        }

        if (null == convertView) {
            return new View(this.mContext);
        }

        // UI Initialization
        DrawerMenuItem item = this.mItems.get(position);

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        imgIcon.setImageResource(item.getIcon());

        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        txtTitle.setText(item.getTitle());

        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);
        txtCount.setText(item.getCount());

        if (item.isCounterVisible()) {
            txtCount.setVisibility(View.VISIBLE);
        } else {
            txtCount.setVisibility(View.GONE);
        }

        return convertView;
    }

    //endregion BaseAdapter implementation
}
