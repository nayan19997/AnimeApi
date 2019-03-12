package com.example.animeapi;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.animeapi.model.Anime;
import com.example.animeapi.model.AnimesList;
import com.example.animeapi.api.AnimedbAPI;
import com.example.animeapi.api.AnimedbModule;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimedbRepository {
    AnimedbAPI animedbAPI;
    public static int offset;
    public AnimedbRepository(){
        animedbAPI = AnimedbModule.getAPI();
    }



    public LiveData<List<Anime>> getAnimes(){
        final MutableLiveData<List<Anime>> lista = new MutableLiveData<>();
        offset = 5;
        animedbAPI.getAnimes(20,offset).enqueue(new Callback<AnimesList>() {
            @Override
            public void onResponse(Call<AnimesList> call, Response<AnimesList> response) {

                lista.setValue(response.body().data);
            }

            @Override
            public void onFailure(Call<AnimesList> call, Throwable t) {
            }
        });

        return lista;
    }
}
