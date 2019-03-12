package com.example.animeapi.view.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.animeapi.R;

public class PelisDesciptoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelis_desciptoin);


        getSupportActionBar().hide();

        // Recieve data

        String id = getIntent().getExtras().getString("peli_id") ;
        String title  = getIntent().getExtras().getString("pelis_name");
        String director = getIntent().getExtras().getString("pelis_director") ;
        String producer = getIntent().getExtras().getString("pelis_producer");
        String release_date = getIntent().getExtras().getString("pelis_release_date") ;
        String description = getIntent().getExtras().getString("pelis_description") ;


        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_id = findViewById(R.id.aa_id);
        TextView tv_title = findViewById(R.id.aa_title);
        TextView tv_director = findViewById(R.id.aa_director) ;
        TextView tv_producer = findViewById(R.id.aa_producer);
        TextView tv_release_date  = findViewById(R.id.aa_release_date) ;
        TextView tv_description  = findViewById(R.id.aa_description) ;

        // setting values to each view

        tv_id.setText(id);
        tv_title.setText(title);
        tv_director.setText(director);
        tv_producer.setText(producer);
        tv_release_date.setText(release_date);
        tv_description.setText(description);

        collapsingToolbarLayout.setTitle(title);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);







    }
}