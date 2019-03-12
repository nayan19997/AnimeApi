package com.example.animeapi.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.animeapi.model.Anime;
import com.example.animeapi.R;
import com.example.animeapi.view.activities.AnimeActivity;

import java.util.ArrayList;
import java.util.List;

public class AnimeListAdapter  extends RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder> {
    private Context mContext ;

    public List<Anime> animeList = new ArrayList<>();



    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_anime, viewGroup, false);
        final AnimeViewHolder animeViewHolder = new AnimeViewHolder(view);
        animeViewHolder.view_contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewGroup.getContext() ,AnimeActivity.class);
                intent.putExtra("anime_title",animeList.get(animeViewHolder.getAdapterPosition()).attributes.titles.en_jp);
                intent.putExtra("anime_title_jp",animeList.get(animeViewHolder.getAdapterPosition()).attributes.titles.ja_jp);
                intent.putExtra("rating",animeList.get(animeViewHolder.getAdapterPosition()).attributes.averageRating);
                intent.putExtra("anime_status",animeList.get(animeViewHolder.getAdapterPosition()).attributes.status);
                intent.putExtra("synopsis",animeList.get(animeViewHolder.getAdapterPosition()).attributes.synopsis);
                intent.putExtra("anime_img",animeList.get(animeViewHolder.getAdapterPosition()).attributes.posterImage.medium);

                viewGroup.getContext().startActivity(intent);
            }
        });

        return animeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder animeViewHolder, int position) {
        Anime anime = animeList.get(position);

        animeViewHolder.tv_title.setText(anime.attributes.titles.en_jp);
        animeViewHolder.tv_title_jp.setText(anime.attributes.titles.ja_jp);

        animeViewHolder.tv_rating.setText(anime.attributes.averageRating);
        animeViewHolder.tv_status.setText(anime.attributes.status);

        Glide.with(animeViewHolder.itemView.getContext()).load("https://media.kitsu.io/anime/poster_images/"+anime.id+"/medium.jpg?1431697256" + anime.attributes.posterImage.medium)
                .into(animeViewHolder.img_portada
        );
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

   public class AnimeViewHolder extends RecyclerView.ViewHolder {
       TextView tv_title;
       TextView tv_title_jp;
       TextView tv_rating;
       TextView tv_status;
       ImageView img_portada;
       LinearLayout view_contenedor;


        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);


            view_contenedor= itemView.findViewById(R.id.contenedor);
            tv_title = itemView.findViewById(R.id.anime_title);
            tv_title_jp = itemView.findViewById(R.id.anime_title_jp);
            tv_rating = itemView.findViewById(R.id.averageRating);
            tv_status = itemView.findViewById(R.id.status);
            img_portada = itemView.findViewById(R.id.portada);
        }
    }
}
