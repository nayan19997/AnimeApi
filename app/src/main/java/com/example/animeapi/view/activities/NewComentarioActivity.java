package com.example.animeapi.view.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.animeapi.R;
import com.example.animeapi.model.Comentario;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewComentarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comentario);

        final ComentarioViewModel comentarioViewModel = ViewModelProviders.of(this).get(ComentarioViewModel.class);

        findViewById(R.id.addComentario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comentario comentario = new Comentario();
                comentario.categoria = ((EditText) findViewById(R.id.comentario_categoria)).getText().toString();
                comentario.title = ((EditText) findViewById(R.id.comentario_title)).getText().toString();
                comentario.content = ((EditText) findViewById(R.id.comentario_content)).getText().toString();
                //poem.date = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
                comentario.date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

                comentarioViewModel.insertComentario(comentario);

                finish();
            }
        });
    }
}