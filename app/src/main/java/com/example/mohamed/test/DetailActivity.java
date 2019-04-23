package com.example.mohamed.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    TextView title,overview,vote,release;
    ImageView poser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title=(TextView) findViewById(R.id.title);
        overview=(TextView) findViewById(R.id.overview);
        vote=(TextView) findViewById(R.id.vote);
        release=(TextView) findViewById(R.id.release);
        poser=(ImageView) findViewById(R.id.poster);

        Intent intent=getIntent();
        ArrayList<Movie> movies=intent.getParcelableArrayListExtra("key");
        int position= intent.getIntExtra("pos",0);

        Movie movie=movies.get(position);

        title.setText(movie.getTitle());
        overview.setText(movie.getOverview());
        vote.setText(movie.getRelease());
        release.setText(movie.getRelease());


        String path=movie.getPoster();

        String value = "w185";
        String base_url = "http://image.tmdb.org/t/p/";
        final String full_url = base_url + value + "/" + path;

        Picasso.get().load(full_url).into(poser);




    }
}
