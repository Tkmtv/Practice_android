package com.example.recyclercard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerRecyclerViewAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    private List<Country> countries;
    private Context context;
    private LayoutInflater mInflater;
    private Toast toast;

    public CustomerRecyclerViewAdapter(List<Country> countries, Context context) {
        this.countries = countries;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recyclerViewItem = mInflater.inflate(R.layout.recylecrview_item_layout,
                parent, false);
        recyclerViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userClickAction((RecyclerView) parent, v);
            }
        });
        return new CountryViewHolder(recyclerViewItem);
    }

    private void userClickAction(RecyclerView recyclerView, View v) {
        int itemPos = recyclerView.getChildLayoutPosition(v);
        Country country = this.countries.get(itemPos);
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this.context, country.toString(), Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = this.countries.get(position);
        int imgId = this.getDrawableResByName(country.getFlagName());
        holder.flagView.setImageResource(imgId);
        holder.countryNameView.setText(country.getCountryName());
        holder.populationView.setText("Population: " + country.getPopulation());
    }

    private int getDrawableResByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i(MainActivity.LOG_TAG, "Res name" + resName + "==> ResID = " + resID);
        return resID;
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
