package com.example.animeapi;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.animeapi.model.Anime;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private AnimedbRepository animedbRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        animedbRepository = new AnimedbRepository();
    }

    public LiveData<List<Anime>> getAnimes(){
        return animedbRepository.getAnimes();
    }
}