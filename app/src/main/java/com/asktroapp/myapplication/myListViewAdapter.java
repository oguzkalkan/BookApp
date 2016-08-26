package com.asktroapp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Oguz on 26.08.2016.
 */
class MyListViewAdapter extends BaseAdapter
{
    List<String> userNames;
    Context context;


    public MyListViewAdapter(List<String> userNames,Context c)
    {
        this.userNames = userNames;
        this.context = c;
    }

    @Override
    public int getCount() {
        return userNames.size();
    }

    @Override
    public Object getItem(int position) {
        return userNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listview_row,viewGroup,false);
        TextView userName = (TextView) rowView.findViewById(R.id.userName);
        userName.setText(userNames.get(i));
        return rowView;

    }
}
