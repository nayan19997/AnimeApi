package com.example.animeapi.view.adapters;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.animeapi.R;
import com.example.animeapi.model.Comentario;
import com.example.animeapi.view.activities.ComentarioViewActivity;
import com.example.animeapi.view.activities.ComentarioViewModel;

import java.util.List;

public class ComentarioRecyclerAdapter extends RecyclerView.Adapter<ComentarioRecyclerAdapter.ComentarioViewHolder>{
    List<Comentario> list;

    public ComentarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemPoem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comentario, parent, false);
        return new ComentarioViewHolder(itemPoem);
    }





    public void onBindViewHolder(ComentarioViewHolder holder, int position) {
        final Comentario comentario = list.get(position);

        holder.comentarioCategoria.setText(comentario.categoria);
        holder.comentarioTitle.setText(comentario.title);
        holder.ratingBar.setRating(comentario.rating);
        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(b){
                    comentario.rating = v;
                    ComentarioViewModel comentarioViewModel = ViewModelProviders.of((AppCompatActivity) ratingBar.getContext()).get(ComentarioViewModel.class);
                    comentarioViewModel.setRating(comentario);
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ComentarioViewActivity.class);
                intent.putExtra("POEM_ID", comentario.id);
                view.getContext().startActivity(intent);
            }
        });
    }



    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    public void setList(List<Comentario> comentarios){
        this.list = comentarios;
    }

    class ComentarioViewHolder extends RecyclerView.ViewHolder {
        private TextView comentarioTitle;
        private TextView comentarioCategoria;
        private RatingBar ratingBar;


       ComentarioViewHolder(View itemcomentario) {
            super(itemcomentario);
            comentarioTitle = itemcomentario.findViewById(R.id.comentario_title);
           comentarioCategoria = itemcomentario.findViewById(R.id.comentario_categoria);
            ratingBar = itemcomentario.findViewById(R.id.ratingBar);
        }
    }
}