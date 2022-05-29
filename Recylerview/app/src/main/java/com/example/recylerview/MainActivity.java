package com.example.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareMovieData();
        recyclerView = findViewById(R.id.recyler_view);
        adapter = new MovieAdapter(list,this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad max: Fury Road", "Action & Adventure", "2015");
        list.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        list.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        list.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        list.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        list.add(movie);

        movie = new Movie("Mission: Impossible Rouge Nation", "Action", "2015");
        list.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        list.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        list.add(movie);

        movie = new Movie("Mad max 2: Fury Road", "Action & Adventure", "2015");
        list.add(movie);

        movie = new Movie("Inside Out 2", "Animation, Kids & Family", "2015");
        list.add(movie);

        movie = new Movie("Star Wars 2: Episode VII - The Force Asleep", "Action", "2015");
        list.add(movie);

        movie = new Movie("Shaun the Sheep 2", "Animation", "2015");
        list.add(movie);

        movie = new Movie("The Martian 2", "Science Fiction & Fantasy", "2015");
        list.add(movie);

        movie = new Movie("Mission 2: Impossible Rouge Nation", "Action", "2015");
        list.add(movie);

        movie = new Movie("Up 2", "Animation", "2009");
        list.add(movie);

        movie = new Movie("Star Trek 2", "Science Fiction", "2009");
        list.add(movie);
    }
}