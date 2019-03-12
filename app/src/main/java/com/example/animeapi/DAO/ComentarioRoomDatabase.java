package com.example.animeapi.DAO;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.animeapi.model.Comentario;

@Database(entities = {Comentario.class}, version = 2)

public abstract class ComentarioRoomDatabase extends RoomDatabase {
    public abstract ComentarioDAO comentarioDAO();

    private static volatile ComentarioRoomDatabase INSTANCE;

    public static ComentarioRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ComentarioRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ComentarioRoomDatabase.class, "poem_database")

                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}