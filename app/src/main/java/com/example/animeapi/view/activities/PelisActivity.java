package com.example.animeapi.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.animeapi.R;
import com.example.animeapi.model.Peli;
import com.example.animeapi.view.adapters.RvAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PelisActivity extends AppCompatActivity {
        private String URL_JSON = "https://ghibliapi.herokuapp.com/films/";
        private JsonArrayRequest ArrayRequest ;
        private RequestQueue requestQueue ;
        private List<Peli> lstAnime = new ArrayList<>();
        private RecyclerView myrv ;


        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pelis);
            myrv = findViewById(R.id.rv);
            jsoncall();




        }

        public void jsoncall() {


            ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    JSONObject jsonObject = null;


                    for (int i = 0 ; i<response.length();i++) {

                        //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                        try {

                            jsonObject = response.getJSONObject(i);
                           Peli peli= new Peli();
                            peli.setId(jsonObject.getString("id"));
                            peli.setTitle(jsonObject.getString("title"));
                            peli.setDescription(jsonObject.getString("description"));
                            peli.setDirector(jsonObject.getString("director"));
                            peli.setProducer(jsonObject.getString("producer"));
                            peli.setRelease_date(jsonObject.getString("release_date"));


                            //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                            lstAnime.add(peli);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                    Toast.makeText(PelisActivity.this,"Size of Liste "+String.valueOf(lstAnime.size()),Toast.LENGTH_SHORT).show();
                    Toast.makeText(PelisActivity.this,lstAnime.get(1).toString(),Toast.LENGTH_SHORT).show();

                    setRvadapter(lstAnime);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(PelisActivity.this);
            requestQueue.add(ArrayRequest);
        }



        public void setRvadapter (List<Peli> lst) {

            RvAdapter myAdapter = new RvAdapter(this,lst) ;
            myrv.setLayoutManager(new LinearLayoutManager(this));
            myrv.setAdapter(myAdapter);




        }


    }