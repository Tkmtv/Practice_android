package com.example.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "Demo App";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Country> countries = getListData();
        this.recyclerView = this.findViewById(R.id.recycler_view);

        recyclerView.setAdapter(new CustomerRecyclerViewAdapter(countries, this));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private List<Country> getListData() {
        List<Country> c = new ArrayList<>();
        Country usa = new Country("USA", "us", 320000000);
        Country aus = new Country("Australia", "australia", 250000000);
        Country ch = new Country("China", "china", 1420000000);
        Country ind = new Country("India", "india", 1260000000);
        Country nz = new Country("New Zealand", "nz", 16000000);
        Country prt = new Country("Portugal", "portugal", 12000000);

        c.add(usa);
        c.add(aus);
        c.add(ch);
        c.add(ind);
        c.add(nz);
        c.add(prt);

        return c;
    }
}