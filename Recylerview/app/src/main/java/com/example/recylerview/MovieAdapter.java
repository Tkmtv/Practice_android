package com.example.recylerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private List<Movie> movies;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private Toast toast;

    public MovieAdapter(List<Movie> movies, Context mContext) {
        this.movies = movies;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, year, genre;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.lbl_title);
            genre = itemView.findViewById(R.id.lbl_genre);
            year = itemView.findViewById(R.id.lbl_year);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast = Toast.makeText(mContext, title.getText(), Toast.LENGTH_SHORT);
                    toast.show();
                    itemView.setBackgroundColor(Color.parseColor("#567845"));
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast= Toast.makeText(mContext, "Long item clicked " + title.getText(), Toast.LENGTH_SHORT);
                    return true;
                }
            });
        }
    }
}
