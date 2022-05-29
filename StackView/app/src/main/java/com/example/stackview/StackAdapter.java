package com.example.stackview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class StackAdapter extends ArrayAdapter<StackItem> {

    private List<StackItem> items;
    private Context context;

    public StackAdapter(@NonNull Context context, int textViewResourceID, List<StackItem> objects) {
        super(context, textViewResourceID, objects);
        items = objects;
        this.context = context;
    }

    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("MyLog", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(R.layout.stack_item, null);
        }
        StackItem stackItem = items.get(position);

        if(stackItem== null)  {
            Log.i("MyLog", "stackItem at " + position + " is null!!!");
            return itemView;
        }
        // TextView defined in the stack_item.xml
        TextView textView = (TextView) itemView.findViewById(R.id.lbl_name);

        // ImageView defined in the stack_item.xml
        ImageView imageView = (ImageView) itemView.findViewById(R.id.lbl_img);

        textView.setText(stackItem.getItemText());

        int resId= stackItem.getIndex();

        imageView.setImageResource(resId);

        return itemView;
    }

}
