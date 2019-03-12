package com.example.animeapi;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.animeapi.DAO.ComentarioDAO;
import com.example.animeapi.DAO.ComentarioRoomDatabase;
import com.example.animeapi.model.Comentario;

import java.util.List;

public class ComentarioRepository {
    private ComentarioDAO mComentarioDAO;

    public ComentarioRepository(Application application) {
        mComentarioDAO = ComentarioRoomDatabase.getDatabase(application).comentarioDAO();
    }

    public LiveData<List<Comentario>> getAllComentarios() {
        return mComentarioDAO.getAllComentario();
    }

    public LiveData<List<Comentario>> getAllComentariosOrderedBy(String order) {
        return mComentarioDAO.getAllComentariosOrderedBy(order);
    }

    public LiveData<Comentario> getComentario(int id){ return mComentarioDAO.getComentario(id); }

    public void insert(Comentario comentario) {
        new InsertAsyncTask(mComentarioDAO).execute(comentario);
    }

    private static class InsertAsyncTask extends AsyncTask<Comentario, Void, Void> {

        private ComentarioDAO mAsyncTaskDao;

        InsertAsyncTask(ComentarioDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Comentario... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public void setRating(Comentario comentario){
        new SetRatingAsyncTask(mComentarioDAO).execute(comentario);
    }

    private static class SetRatingAsyncTask extends AsyncTask<Comentario, Void, Void> {

        private ComentarioDAO mAsyncTaskDao;

        SetRatingAsyncTask(ComentarioDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Comentario... comentarios) {
            mAsyncTaskDao.setRating(comentarios[0].id, comentarios[0].rating);
            return null;
        }
    }


}