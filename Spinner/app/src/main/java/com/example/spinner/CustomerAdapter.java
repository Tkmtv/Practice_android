package com.example.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomerAdapter extends BaseAdapter {

    Context context;
    int flag[];
    String[] countryNames;
    LayoutInflater inflater;

    public CustomerAdapter(Context context, int[] flag, String[] countryNames) {
        this.context = context;
        this.flag = flag;
        this.countryNames = countryNames;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return flag.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.spinner_item, null);
        ImageView icon = convertView.findViewById(R.id.imageView);
        TextView names = convertView.findViewById(R.id.textView);
        icon.setImageResource(flag[position]);
        names.setText(countryNames[position]);
        return convertView;
    }
}
