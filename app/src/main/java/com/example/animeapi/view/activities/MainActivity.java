package com.example.animeapi.view.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.animeapi.view.adapters.AnimeListAdapter;
import com.example.animeapi.MainViewModel;
import com.example.animeapi.model.Anime;
import com.example.animeapi.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AnimeApi";
    private MainViewModel aViewModel;
    private RecyclerView aRecyclerView;
    private AnimeListAdapter aAnimeListAdapter;
//    boolean isScrolling = false;
//    int currentItems, totalItems, scrollOutItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aRecyclerView = findViewById(R.id.animeList);

        aRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        aAnimeListAdapter = new AnimeListAdapter();
        aRecyclerView.setAdapter(aAnimeListAdapter);

        aViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        aViewModel.getAnimes().observe(this, new Observer<List<Anime>>() {
            @Override
            public void onChanged(@Nullable List<Anime> animes) {
                aAnimeListAdapter.animeList = animes;
                aAnimeListAdapter.notifyDataSetChanged();
            }
        });
//     //---------------------------------------------------------//

    }
}