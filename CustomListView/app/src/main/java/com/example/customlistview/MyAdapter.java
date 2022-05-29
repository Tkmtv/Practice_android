package com.example.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Employee> list;

    public MyAdapter(Context context, ArrayList<Employee> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        create object listview_row stand for a row of list view
        ListView_Row lv_row;

//        check object is null
        if (convertView == null) {
//            init inflater
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

//            cast converview to layout listview
            convertView = inflater.inflate(R.layout.list_view_item, null);

//            get control
            lv_row = new ListView_Row();
            lv_row.avatar = convertView.findViewById(R.id.avatar);
            lv_row.name = convertView.findViewById(R.id.lbl_name);
            lv_row.select = convertView.findViewById(R.id.ck_sel);

            convertView.setTag(lv_row);

        } else {
            lv_row = (ListView_Row) convertView.getTag();
        }

//        add data from list
        if (list.get(position).isGender()) {
            lv_row.avatar.setImageResource(R.drawable.male_user);
        } else {
            lv_row.avatar.setImageResource(R.drawable.female_user);
        }
        lv_row.name.setText(list.get(position).toString());

        return convertView;
    }

    private class ListView_Row {
        public ImageView avatar;
        public TextView name;
        public CheckBox select;
    }
}
