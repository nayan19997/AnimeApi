package com.example.animeapi.view.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.animeapi.GlideApp;
import com.example.animeapi.R;

public class AnimeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        getSupportActionBar().hide();



        String title  = getIntent().getExtras().getString("anime_title");
        String title_jp = getIntent().getExtras().getString("anime_title_jp");
        String synopsis = getIntent().getExtras().getString("synopsis");
        String status = getIntent().getExtras().getString("anime_status") ;
        String rating = getIntent().getExtras().getString("rating") ;
        String portada = getIntent().getExtras().getString("anime_img") ;


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);


        TextView tv_title = findViewById(R.id.aa_anime_title);
        TextView tv_title_jp = findViewById(R.id.aa_anime_title_jp);
        TextView tv_rating = findViewById(R.id.aa_averageRating);
        TextView tv_status = findViewById(R.id.aa_status);
        TextView tv_synopsis = findViewById(R.id.aa_synopsis);
        ImageView img = findViewById(R.id.aa_portada);



        tv_title.setText(title);
        tv_title_jp.setText(title_jp);
        tv_rating.setText(rating);
        tv_status.setText(status);
        tv_synopsis.setText(synopsis);
        collapsingToolbarLayout.setTitle(title);

        GlideApp.with(this)
                .load(portada)
                .into(img);




    }
}
