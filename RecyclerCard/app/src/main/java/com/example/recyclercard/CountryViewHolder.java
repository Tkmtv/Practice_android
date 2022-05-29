package com.example.recyclercard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    ImageView flagView;
    TextView countryNameView;
    TextView populationView;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.flagView = itemView.findViewById(R.id.img_flag);
        this.countryNameView = itemView.findViewById(R.id.lbl_title);
        this.populationView = itemView.findViewById(R.id.lbl_pop);
    }
}
