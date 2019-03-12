package com.example.animeapi.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity

public class Comentario {
    @PrimaryKey (autoGenerate = true)

    public int id;
    public  String title;
    public  String categoria;
    public  String content;
    public  String date;
    public  float rating;
}
