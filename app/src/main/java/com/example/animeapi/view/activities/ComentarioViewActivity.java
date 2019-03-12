package com.example.animeapi.view.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.animeapi.R;
import com.example.animeapi.model.Comentario;

public class ComentarioViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario_view);
        int poemId = getIntent().getIntExtra("POEM_ID",0);

        ComentarioViewModel comentarioViewModel = ViewModelProviders.of(this).get(ComentarioViewModel.class);

        comentarioViewModel.getPoem(poemId).observe(this, new Observer<Comentario>() {
            @Override
            public void onChanged(@Nullable Comentario comentario) {
                if(comentario != null) {
                    ((TextView) findViewById(R.id.comentario_title)).setText(comentario.title);
                    ((TextView) findViewById(R.id.comentario_categoria)).setText(comentario.categoria);
                    ((RatingBar) findViewById(R.id.comentario_rating)).setRating(comentario.rating);
                    ((TextView) findViewById(R.id.comentario_content)).setText(comentario.content);
                }
            }
        });
    }
}
