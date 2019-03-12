package com.example.animeapi.view.activities;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.animeapi.ComentarioRepository;
import com.example.animeapi.model.Comentario;

import java.util.List;

public class ComentarioViewModel extends AndroidViewModel {
    private ComentarioRepository mRepository;

    public ComentarioViewModel(Application application) {
        super(application);
        mRepository = new ComentarioRepository(application);
    }

    LiveData<List<Comentario>> getAllPoems() { return mRepository.getAllComentarios(); }

    public LiveData<List<Comentario>> getAllPoemsOrderedBy(String order) { return mRepository.getAllComentariosOrderedBy(order); }

    LiveData<Comentario> getPoem(int id){ return mRepository.getComentario(id); }

    public void insertComentario(Comentario comentario) { mRepository.insert(comentario); }

    public void setRating(Comentario comentario) { mRepository.setRating(comentario); }
}


