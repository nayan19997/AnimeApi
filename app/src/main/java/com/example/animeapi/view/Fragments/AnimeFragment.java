package com.example.animeapi.view.Fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animeapi.model.Anime;
import com.example.animeapi.R;
import com.example.animeapi.view.adapters.AnimeListAdapter;
import com.example.animeapi.MainViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimeFragment extends Fragment {

    private MainViewModel aViewModel;
    private RecyclerView aRecyclerView;
    private AnimeListAdapter aAnimeListAdapter;

    public AnimeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_anime, container, false);

        aRecyclerView = view.findViewById(R.id.animeList);

        aRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
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


        return view;
    }

}
