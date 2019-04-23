package com.example.mohamed.test;

import android.content.Intent;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MovieAdapter.OnItem {

    RetrofitInterface anInterface;
    Movie movie;
    MovieAdapter adapter;
    RecyclerView recyclerView;
    List<Movie> movies;
    String base_url="http://api.themoviedb.org";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.list);

          if(savedInstanceState !=null){
             // recyclerView.getLayoutManager().onRestoreInstanceState((Parcelable)movies);
              movies=savedInstanceState.getParcelableArrayList("key");
          }
        getPopulated();


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        movies=savedInstanceState.getParcelableArrayList("key");
    }

    @Override
    public void onItemClick(Movie movie,int position) {

        Intent intent=new Intent(MainActivity.this,DetailActivity.class);
        intent.putParcelableArrayListExtra("key", (ArrayList<? extends Parcelable>) movies);
        intent.putExtra("pos",position);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch (id){
            case R.id.populated :
                getPopulated();
                break;

            case R.id.top_reted :
                getTopRated();
                break;
        }

        return true;
    }

    private void getPopulated() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create()).build();

        anInterface=retrofit.create(RetrofitInterface.class);

        Call<MovieList> movieListCall=anInterface.getPopulate("popular",RetrofitInterface.apiKey);

        movieListCall.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                movies=response.body().getMoviList();
                adapter=new MovieAdapter(movies,getApplicationContext(),MainActivity.this);
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
                recyclerView.setAdapter(adapter);
                Log.v("MainActivity","ssssssssss:"+movies.size());
                Log.v("MainActivity","ssssssssss:"+movies.get(1));


            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }
        });




    }

    private void getTopRated() {


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        anInterface=retrofit.create(RetrofitInterface.class);

        Call<MovieList> movieListCall=anInterface.getTopRatedMovi("top_rated",RetrofitInterface.apiKey);
        movieListCall.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                movies=response.body().getMoviList();
                adapter=new MovieAdapter(movies,getApplicationContext(),MainActivity.this);
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }
        });
        }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
     outState.putParcelableArrayList("key", (ArrayList<? extends Parcelable>) movies);



    }
}
