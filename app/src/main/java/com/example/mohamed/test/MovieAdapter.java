package com.example.mohamed.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder>{

 private List<Movie> movies;
 private Context context;
 private OnItem mOnItem;


 public  interface  OnItem{
     void onItemClick(Movie movie,int position);
 }

    public MovieAdapter(List<Movie> movies, Context context,OnItem onItem) {
        this.movies = movies;
        this.context = context;
         this.mOnItem=onItem;
    }


    @NonNull
    @Override
    public MovieAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.Holder holder, final int position) {

        final Movie movie=movies.get(position);
        String path=movie.getPoster();
        String value = "w185";
        String base_url = "http://image.tmdb.org/t/p/";
        final String full_url = base_url + value + "/" + path;
        Picasso.get().load(full_url).into(holder.imageView);
        holder.textView.setText(movie.getTitle());



        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItem.onItemClick(movie,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
           imageView=(ImageView) itemView.findViewById(R.id.poster);
           textView=(TextView) itemView.findViewById(R.id.text);


        }
    }
}
