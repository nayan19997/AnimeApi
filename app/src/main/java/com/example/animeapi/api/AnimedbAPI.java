package com.example.animeapi.api;

import com.example.animeapi.model.AnimesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AnimedbAPI {
    @GET("anime")
    Call<AnimesList> getAnimes(@Query("page[limit]") int limit, @Query("page[offset]") int  offset );
}
