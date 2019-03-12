package com.example.animeapi.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.animeapi.model.Comentario;

import java.util.List;

@Dao

public abstract class ComentarioDAO {
    @Insert
    public abstract void insert(Comentario comentario);

    @Query("SELECT * FROM comentario")
    public abstract LiveData<List<Comentario>> getAllComentario();

    @Query("SELECT * FROM comentario ORDER BY date DESC")
    abstract LiveData<List<Comentario>> getAllComentarioOrderedByDate();

    @Query("SELECT * FROM comentario ORDER BY title")
    abstract LiveData<List<Comentario>> getAllComentarioOrderedByTitle();

    @Query("SELECT * FROM comentario ORDER BY rating DESC")
    abstract LiveData<List<Comentario>> getAllComentarioOrderedByRating();


    public LiveData<List<Comentario>> getAllComentariosOrderedBy(String order){
        if(order.equals("date")){
            return getAllComentarioOrderedByDate();
        }else if(order.equals("rating")){
            return getAllComentarioOrderedByRating();
        }
        return getAllComentarioOrderedByTitle();
    }



    @Query("SELECT * FROM comentario WHERE id = :id")
    public abstract LiveData<Comentario> getComentario(int id);

    @Query("UPDATE comentario SET rating=:rating WHERE id=:id")
    public abstract void setRating(int id, float rating);


}
